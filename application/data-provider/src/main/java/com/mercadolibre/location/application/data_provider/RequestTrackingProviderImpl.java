/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.data_provider;

import com.mercadolibre.location.application.core.provider.RequestTrackingProvider;
import com.mercadolibre.location.application.core.use_case.entity.CountryTrackingEntity;
import com.mercadolibre.location.application.data_provider.adapter.CountryTrackingAdapter;

import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Implements logic for get information on locations where requests have been made
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Component
public class RequestTrackingProviderImpl implements RequestTrackingProvider {

    /** For query country tracking information **/
    private final CountryTrackingAdapter adapter;

    /**
     * RequestTrackingProviderImpl Constructor
     *
     * @param adapter For query country tracking information
     */
    public RequestTrackingProviderImpl(final CountryTrackingAdapter adapter) {

        this.adapter = adapter;
    }

    /**
     * Tracking information about the country where the request is made
     *
     * @param ip Where the request starts
     * @return Tracking information
     */
    @Override
    public CountryTrackingEntity trace(final String ip) {

        try {
            return adapter.trace(ip);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }

}