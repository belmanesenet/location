/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.core.use_case.impl;

import com.mercadolibre.location.application.core.provider.RequestTrackingProvider;
import com.mercadolibre.location.application.core.use_case.RequestTrackingUseCase;
import com.mercadolibre.location.application.core.use_case.entity.CountryTrackingEntity;

/**
 * Implements logic for get information on locations where requests have been made
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
public class RequestTrackingUseCaseImpl implements RequestTrackingUseCase {

    /** Provides information about locations where request have been made **/
    private final RequestTrackingProvider provider;

    /**
     * RequestTrackingUseCaseImpl Constructor
     * @param provider
     */
    public RequestTrackingUseCaseImpl(final RequestTrackingProvider provider) {

        this.provider = provider;
    }

    /**
     * Tracking information about the country where the request is made
     *
     * @param ip Where the request starts
     * @return Tracking information
     */
    @Override
    public CountryTrackingEntity trace(final String ip) {

        return provider.trace(ip);
    }


}