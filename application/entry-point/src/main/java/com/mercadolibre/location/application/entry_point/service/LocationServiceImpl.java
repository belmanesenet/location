/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 04:08 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.service;

import com.mercadolibre.location.application.entry_point.client.CurrencyClient;
import com.mercadolibre.location.application.entry_point.client.TraceClient;
import com.mercadolibre.location.application.entry_point.controller.dto.CountryInvocationDto;
import com.mercadolibre.location.application.entry_point.controller.dto.TraceIpInfoDto;
import com.mercadolibre.location.application.entry_point.controller.dto.currency_response.CurrencyExchangeResponseDto;
import com.mercadolibre.location.application.entry_point.controller.vo.StatsResponseVo;
import com.mercadolibre.location.application.entry_point.controller.vo.TraceResponseVo;
import com.mercadolibre.location.application.entry_point.repository.CountryInvocationRedisRepository;
import com.mercadolibre.location.application.entry_point.tool.DistanceCalculator;
import okhttp3.OkHttpClient;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Objects;

/**
 * Service to manage the search logic of country LocationDto and statics information
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Service
public class LocationServiceImpl implements LocationService {

    /** Log information **/
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationServiceImpl.class);

    /** Caching country invocation repository **/
    private final CountryInvocationRedisRepository countryInvocationRedisRepository;

    /** Calculate distance between Buenos Aires and place where the request is made **/
    private final DistanceCalculator distanceCalculator;

    /**
     * LocationServiceImpl Constructor
     *
     * @param distanceCalculator between Buenos Aires and place where the request is made in Km
     * @param countryInvocationRedisRepository
     */
    public LocationServiceImpl(final CountryInvocationRedisRepository countryInvocationRedisRepository,
                               final DistanceCalculator distanceCalculator) {

        this.countryInvocationRedisRepository = countryInvocationRedisRepository;
        this.distanceCalculator = distanceCalculator;
    }

    /**
     * Shows statistical information about requests made to the service
     *
     * @return Statistical information on requests to the service
     */
    @Override
    public StatsResponseVo stats() {

        LOGGER.info("initializes the statistics calculation process in service layer");

        Map<String, CountryInvocationDto> countryInvocationMap = countryInvocationRedisRepository.findAll();

        if(countryInvocationMap.size() > 0) {
            Map.Entry<String, CountryInvocationDto> firstCountry = countryInvocationMap.entrySet().iterator().next();

            double farthestDistance = Double.parseDouble(firstCountry.getValue().getDistance());
            double closestDistance = farthestDistance;
            double distancePerInvocations = 0D;
            double sumOfInvocations = 0D;


            for (Map.Entry<String, CountryInvocationDto> country : countryInvocationMap.entrySet()) {
                double distance = Double.parseDouble(country.getValue().getDistance());
                double invocation = Double.parseDouble(country.getValue().getInvocations());
                farthestDistance = Math.max(distance, farthestDistance);
                closestDistance = Math.min(distance, closestDistance);
                distancePerInvocations += distance * invocation;
                sumOfInvocations += invocation;
            }

            double averageDistance = distancePerInvocations / sumOfInvocations;

            return new StatsResponseVo(farthestDistance, closestDistance, averageDistance);
        } else {
            return new StatsResponseVo(0D, 0D, 0D);
        }

    }

    /**
     * Tracking information about the country where the request is made
     *
     * @param ip Where the request starts
     * @return Tracking information
     */
    @Override
    public TraceResponseVo trace(final String ip) throws IOException {

        LOGGER.info("initialize request tracking process in service layer");

        Retrofit traceRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        Retrofit currencyRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.cambio.today/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        TraceClient traceClient = traceRetrofit.create(TraceClient.class);

        CurrencyClient currencyClient = currencyRetrofit.create(CurrencyClient.class);

        TraceIpInfoDto traceIpInfoDto = traceClient.trace(ip, "e394d38a046a334ad418054c57d0e115").execute().body();

        CurrencyExchangeResponseDto currencyExchangeResponseDto =
            currencyClient.exchange("EUR", traceIpInfoDto.getCurrency().getCode(),
                "1", "13840|y~a8Nmq3rpQmnSvbe^kMUH4XwmoZ3Wtw").execute().body();

        /** calculate the distance to Buenos Aires **/
        double distance = distanceCalculator.distanceToBuenosAires(
            Double.parseDouble(traceIpInfoDto.getLatitude()), Double.parseDouble(traceIpInfoDto.getLongitude()));

        /** Currency code **/
        String currencyCode = traceIpInfoDto.getCurrency().getCode();

        TraceResponseVo traceResponseVo = new ModelMapper().map(traceIpInfoDto, TraceResponseVo.class);
        traceResponseVo.setCountryName(traceIpInfoDto.getCountryName());
        traceResponseVo.setCurrency(currencyCode + " (1 EUR = "
            + currencyExchangeResponseDto.getResult().getValue() + " " + currencyCode + ")");
        traceResponseVo.setDate(new Timestamp(System.currentTimeMillis()) + "");
        traceResponseVo.setEstimatedDistance(distance + " Km to Buenos Aires, Argentina");
        traceResponseVo.setLanguages(traceIpInfoDto.getLocation().getLanguages());
        traceResponseVo.setTimes(traceIpInfoDto.getTimeZone().getCurrentTime());

        CountryInvocationDto byCountryName = countryInvocationRedisRepository.findByCountryName(traceResponseVo.getCountryName());

        String invocations = Objects.isNull(byCountryName) ? "1" : "" + (Integer.parseInt(byCountryName.getInvocations()) + 1);

        countryInvocationRedisRepository.save(
            new CountryInvocationDto(traceResponseVo.getCountryName(), distance + "", invocations));

        return traceResponseVo;
    }

}