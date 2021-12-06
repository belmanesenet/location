/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.data_provider;

import com.mercadolibre.location.application.core.provider.DistanceStatsProvider;
import com.mercadolibre.location.application.core.use_case.entity.CountryInformationEntity;
import com.mercadolibre.location.application.data_provider.adapter.DistanceStatsAdapter;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Implement the provider consulting information about the requests in data provider layer
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Component
public class DistanceStatsProviderImpl implements DistanceStatsProvider {

    /** Adapts the information queried from a data source to the information requested in the core layer **/
    private final DistanceStatsAdapter adapter;

    /**
     * DistanceStatsProviderImpl constructor
     *
     * @param adapter for query information about requests
     */
    public DistanceStatsProviderImpl(final DistanceStatsAdapter adapter) {

        this.adapter = adapter;
    }

    /**
     * Get summary about request to the service
     *
     * @return Country, distance and invocation to the service
     */
    @Override
    public Map<String, CountryInformationEntity> getSummary() {

        return adapter.getSummary();
    }

}