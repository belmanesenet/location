/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:09 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.presenter;

import com.mercadolibre.location.application.entry_point.controller.vo.CountryTrackingVo;
import org.springframework.stereotype.Component;

/**
 * Definition of service request trace in presenter layer
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Component
public interface RequestTrackingPresenter {

    /**
     * Tracking information about the country where the request is made
     *
     * @param ip Where the request starts
     * @return Tracking information
     */
    CountryTrackingVo trace(final String ip);

}