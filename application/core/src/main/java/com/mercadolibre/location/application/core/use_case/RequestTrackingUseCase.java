/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.core.use_case;

import com.mercadolibre.location.application.core.use_case.entity.CountryTrackingEntity;

/**
 * Provides information on locations where requests have been made
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
public interface RequestTrackingUseCase {


    /**
     * Tracking information about the country where the request is made
     *
     * @param ip Where the request starts
     * @return Tracking information
     */
    CountryTrackingEntity trace(final String ip);

}