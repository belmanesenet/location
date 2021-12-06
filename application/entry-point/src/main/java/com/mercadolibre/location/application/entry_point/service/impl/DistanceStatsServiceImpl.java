package com.mercadolibre.location.application.entry_point.service.impl;

import com.mercadolibre.location.application.entry_point.controller.vo.CountryStatsVo;
import com.mercadolibre.location.application.entry_point.DistanceStatsPresenter;
import com.mercadolibre.location.application.entry_point.service.DistanceStatsService;

import org.springframework.stereotype.Service;

@Service
public class DistanceStatsServiceImpl implements DistanceStatsService {

    /** Presenter for get information about locations**/
    private final DistanceStatsPresenter presenter;

    /**
     * DistanceStatsServiceImpl constructor
     *
     * @param presenter With information like country, distance and invocations
     */
    public DistanceStatsServiceImpl(final DistanceStatsPresenter presenter) {

        this.presenter = presenter;
    }

    /**
     * Shows information related to the distance from where the requests are made
     *
     * @return Country, distance and invocations to the service
     */
    @Override
    public CountryStatsVo getSummary() {

        return presenter.getSummary();
    }

}