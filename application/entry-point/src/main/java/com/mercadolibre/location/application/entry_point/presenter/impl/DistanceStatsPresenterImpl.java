/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.presenter.impl;

import com.mercadolibre.location.application.core.use_case.DistanceStatsUseCase;
import com.mercadolibre.location.application.entry_point.presenter.DistanceStatsPresenter;
import com.mercadolibre.location.application.entry_point.controller.vo.CountryStatsVo;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * implementation of logic for get information on
 * locations where requests have been made in entry point layer
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Component
public class DistanceStatsPresenterImpl implements DistanceStatsPresenter {

    /** Use case for get information about locations**/
    private final DistanceStatsUseCase useCase;

    /**
     * DistanceStatsPresenterImpl constructor
     *
     * @param useCase With information like country, distance and invocations
     */
    public DistanceStatsPresenterImpl(final DistanceStatsUseCase useCase) {

        this.useCase = useCase;
    }

    /**
     * Shows information related to the distance from where the requests are made
     *
     * @return Country, distance and invocations to the service
     */
    @Override
    public CountryStatsVo getSummary() {

        return new ModelMapper().map(useCase.getSummary(), CountryStatsVo.class);
    }

}