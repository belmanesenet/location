/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.data_provider.adapter;

import com.mercadolibre.location.application.core.use_case.entity.CountryLanguageEntity;
import com.mercadolibre.location.application.core.use_case.entity.CountryTrackingEntity;
import com.mercadolibre.location.application.data_provider.client.CurrencyClient;
import com.mercadolibre.location.application.data_provider.client.TraceClient;
import com.mercadolibre.location.application.data_provider.configuration.RetrofitProperty;
import com.mercadolibre.location.application.data_provider.model.redis.CountryInformationModel;
import com.mercadolibre.location.application.data_provider.model.retrofit.CurrencyExchangeResponseModel;
import com.mercadolibre.location.application.data_provider.model.retrofit.TraceIpInfoModel;
import com.mercadolibre.location.application.data_provider.repository.CountryInformationRepository;
import com.mercadolibre.location.application.data_provider.tool.DistanceCalculator;

import okhttp3.OkHttpClient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Implements logic for get information on locations where requests have been made
 * Mapping query to entity for core layer
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Component
public class CountryTrackingAdapter {

    /** Query the summary from sources **/
    private final CountryInformationRepository repository;

    /** Calculate distance between Buenos Aires and place where the request is made **/
    private final DistanceCalculator distanceCalculator;

    /** Read retrofit client configuration **/
    private final RetrofitProperty property;

    /**
     * LocationServiceImpl Constructor
     *
     * @param distanceCalculator between Buenos Aires and place where the request is made in Km
     * @param repository
     * @param property
     */
    public CountryTrackingAdapter(final DistanceCalculator distanceCalculator,
                                  final CountryInformationRepository repository,
                                  final RetrofitProperty property) {

        this.distanceCalculator = distanceCalculator;
        this.repository = repository;
        this.property = property;
    }

    /**
     * Tracking information about the country where the request is made
     *
     * @param ip Where the request starts
     * @return Tracking information
     */
    public CountryTrackingEntity trace(final String ip) throws IOException {

        Retrofit traceRetrofit = new Retrofit.Builder()
                .baseUrl(property.getTraceUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        Retrofit currencyRetrofit = new Retrofit.Builder()
                .baseUrl(property.getCurrencyUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        TraceClient traceClient = traceRetrofit.create(TraceClient.class);

        CurrencyClient currencyClient = currencyRetrofit.create(CurrencyClient.class);

        TraceIpInfoModel traceIpInfoModel = traceClient.trace(ip, property.getTraceKey()).execute().body();

        CurrencyExchangeResponseModel currencyExchangeResponseDto =
            currencyClient.exchange("EUR", traceIpInfoModel.getCurrency().getCode(),
                "1", property.getCurrencyKey()).execute().body();


        /** calculate the distance to Buenos Aires **/
        double distance = distanceCalculator.distanceToBuenosAires(
                Double.parseDouble(traceIpInfoModel.getLatitude()), Double.parseDouble(traceIpInfoModel.getLongitude()));

        /** Currency code **/
        String currencyCode = traceIpInfoModel.getCurrency().getCode();

        CountryTrackingEntity countryTrackingEntity = new ModelMapper().map(traceIpInfoModel, CountryTrackingEntity.class);
        countryTrackingEntity.setCountryName(traceIpInfoModel.getCountryName());
        countryTrackingEntity.setCurrency(currencyCode + " (1 EUR = "
            + currencyExchangeResponseDto.getResult().getValue() + " " + currencyCode + ")");
        countryTrackingEntity.setDate(new Timestamp(System.currentTimeMillis()) + "");
        countryTrackingEntity.setEstimatedDistance(distance + " Km to Buenos Aires, Argentina");
        countryTrackingEntity.setTimes(traceIpInfoModel.getTimeZone().getCurrentTime());
        countryTrackingEntity.setLanguages(traceIpInfoModel.getLocation().getLanguages().stream().map(
            languageModel -> new ModelMapper().map(languageModel, CountryLanguageEntity.class)).collect(Collectors.toList()));

        CountryInformationModel byCountryName = repository.findByCountryName(countryTrackingEntity.getCountryName());

        String invocations = Objects.isNull(byCountryName) ? "1" : "" + (Integer.parseInt(byCountryName.getInvocations()) + 1);

        repository.save(new CountryInformationModel(countryTrackingEntity.getCountryName(), distance + "", invocations));

        return countryTrackingEntity;
    }

}