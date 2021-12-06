/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.core.use_case.impl;

import com.mercadolibre.location.application.core.provider.DistanceStatsProvider;
import com.mercadolibre.location.application.core.use_case.DistanceStatsUseCase;
import com.mercadolibre.location.application.core.use_case.entity.CountryInformationEntity;
import com.mercadolibre.location.application.core.use_case.entity.CountryStatsEntity;

import java.util.Map;

/**
 * Implement use case to get information on locations where requests have been made
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
public class DistanceStatsUseCaseImpl implements DistanceStatsUseCase {

    /** provides information on locations where requests have been made **/
    private final DistanceStatsProvider provider;

    /**
     * DistanceStatsUseCaseImpl constructor
     *
     * @param provider Information on location from data provider layer
     */
    public DistanceStatsUseCaseImpl(final DistanceStatsProvider provider) {

        this.provider = provider;
    }

    /**
     * Shows information related to the distance from where the requests are made
     *
     * @return Country, distance and invocations to the service
     */
    @Override
    public CountryStatsEntity getSummary() {

        Map<String, CountryInformationEntity> countryInformations = provider.getSummary();

        if(countryInformations.size() > 0) {
            Map.Entry<String, CountryInformationEntity> firstCountry = countryInformations.entrySet().iterator().next();

            double farthestDistance = Double.parseDouble(firstCountry.getValue().getDistance());
            double closestDistance = farthestDistance;
            double distancePerInvocations = 0D;
            double sumOfInvocations = 0D;


            for (Map.Entry<String, CountryInformationEntity> country : countryInformations.entrySet()) {
                double distance = Double.parseDouble(country.getValue().getDistance());
                double invocation = Double.parseDouble(country.getValue().getInvocations());
                farthestDistance = Math.max(distance, farthestDistance);
                closestDistance = Math.min(distance, closestDistance);
                distancePerInvocations += distance * invocation;
                sumOfInvocations += invocation;
            }

            double averageDistance = distancePerInvocations / sumOfInvocations;

            return new CountryStatsEntity(farthestDistance, closestDistance, averageDistance);
        } else {
            return new CountryStatsEntity(0D, 0D, 0D);
        }

    }

}