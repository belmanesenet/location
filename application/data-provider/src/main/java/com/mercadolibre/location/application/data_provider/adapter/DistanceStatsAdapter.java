/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.data_provider.adapter;

import com.mercadolibre.location.application.core.use_case.entity.CountryInformationEntity;
import com.mercadolibre.location.application.data_provider.repository.CountryInformationRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Cast information from models to entities
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Component
public class DistanceStatsAdapter {

    /** Query the summary from sources **/
    private final CountryInformationRepository repository;

    /**
     * DistanceStatsAdapter constructor
     *
     * @param repository
     */
    public DistanceStatsAdapter(final CountryInformationRepository repository) {

        this.repository = repository;
    }

    /**
     * Cast information about requests from models to entities
     * @return a Map with country request information
     */
    public Map<String, CountryInformationEntity> getSummary() {

        Map<String, CountryInformationEntity> countryInformationEntities = new HashMap<>();

        repository.findAll().forEach((country, countryInformationModel) -> {
            countryInformationEntities.put(country,
                new ModelMapper().map(countryInformationModel, CountryInformationEntity.class));
        });

        return countryInformationEntities;
    }

}