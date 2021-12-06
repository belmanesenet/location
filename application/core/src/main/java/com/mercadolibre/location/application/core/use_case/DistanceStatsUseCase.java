/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.core.use_case;

import com.mercadolibre.location.application.core.use_case.entity.CountryStatsEntity;

/**
 * Information on locations where requests have been made in core layer
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
public interface DistanceStatsUseCase {

    /**
     * Shows information related to the distance from where the requests are made
     *
     * @return Country, distance and invocations to the service
     */
    CountryStatsEntity getSummary();

}