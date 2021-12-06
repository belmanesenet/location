package com.mercadolibre.location.application.entry_point.service.impl;

import com.mercadolibre.location.application.entry_point.controller.vo.CountryTrackingVo;
import com.mercadolibre.location.application.entry_point.presenter.RequestTrackingPresenter;
import com.mercadolibre.location.application.entry_point.service.RequestTrackingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * Implementation of service request trace in presenter layer
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Service
public class RequestTrackingServiceImpl implements RequestTrackingService {

    /** Provides information on locations where requests have been made **/
    private final RequestTrackingPresenter presenter;

    /**
     * RequestTrackingPresenterImpl constructor
     *
     * @param presenter for execute logic of tracking
     */
    public RequestTrackingServiceImpl(final RequestTrackingPresenter presenter) {

        this.presenter = presenter;
    }

    /**
     * Tracking information about the country where the request is made
     *
     * @param ip Where the request starts
     * @return Tracking information
     */
    @Override
    public CountryTrackingVo trace(final String ip) {

        return new ModelMapper().map(presenter.trace(ip), CountryTrackingVo.class);
    }

}
