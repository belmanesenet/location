/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.presenter;

import com.mercadolibre.location.application.entry_point.controller.vo.CountryStatsVo;

/**
 * Information on locations where requests have been made in entry point layer
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
public interface DistanceStatsPresenter {

    /**
     * Shows information related to the distance from where the requests are made
     *
     * @return Country, distance and invocations to the service
     */
    CountryStatsVo getSummary();

}