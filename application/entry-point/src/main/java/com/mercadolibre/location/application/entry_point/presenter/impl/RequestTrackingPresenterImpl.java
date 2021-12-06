package com.mercadolibre.location.application.entry_point.presenter.impl;

import com.mercadolibre.location.application.core.use_case.RequestTrackingUseCase;
import com.mercadolibre.location.application.entry_point.controller.vo.CountryTrackingVo;
import com.mercadolibre.location.application.entry_point.presenter.RequestTrackingPresenter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of service request trace in presenter layer
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Component
public class RequestTrackingPresenterImpl implements RequestTrackingPresenter {

    /** Provides information on locations where requests have been made **/
    private final RequestTrackingUseCase useCase;

    /**
     * RequestTrackingPresenterImpl constructor
     *
     * @param useCase for execute logic of tracking
     */
    public RequestTrackingPresenterImpl(final RequestTrackingUseCase useCase) {

        this.useCase = useCase;
    }

    /**
     * Tracking information about the country where the request is made
     *
     * @param ip Where the request starts
     * @return Tracking information
     */
    @Override
    public CountryTrackingVo trace(final String ip) {

        return new ModelMapper().map(useCase.trace(ip), CountryTrackingVo.class);
    }

}
