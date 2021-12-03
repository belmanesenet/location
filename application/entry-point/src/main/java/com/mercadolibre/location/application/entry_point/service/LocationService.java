/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:09 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.service;

import com.mercadolibre.location.application.entry_point.controller.vo.StatsResponseVo;
import com.mercadolibre.location.application.entry_point.controller.vo.TraceResponseVo;

import java.io.IOException;

/**
 * interface to manage the search logic of country LocationDto and statics information
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
public interface LocationService {

    /**
     * Shows statistical information about requests made to the service
     *
     * @return Statistical information on requests to the service
     */
    StatsResponseVo stats();

    /**
     * Tracking information about the country where the request is made
     *
     * @param ip Where the request starts
     * @return Tracking information
     */
    TraceResponseVo trace(final String ip) throws IOException;

}