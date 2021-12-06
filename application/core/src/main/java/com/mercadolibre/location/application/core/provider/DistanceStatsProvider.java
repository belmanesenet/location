/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.core.provider;

import com.mercadolibre.location.application.core.use_case.entity.CountryInformationEntity;

import java.util.Map;

/**
 * provides information on locations where requests have been made
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
public interface DistanceStatsProvider {

    /**
     * Shows information related to the distance from where the requests are made
     *
     * @return Country, distance and invocations to the service
     */
    Map<String, CountryInformationEntity> getSummary();

}