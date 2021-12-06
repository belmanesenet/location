/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.controller;

import com.mercadolibre.location.application.entry_point.controller.vo.CountryStatsVo;
import com.mercadolibre.location.application.entry_point.controller.vo.CountryTrackingVo;
import com.mercadolibre.location.application.entry_point.controller.vo.IpVo;
import com.mercadolibre.location.application.entry_point.service.DistanceStatsService;
import com.mercadolibre.location.application.entry_point.service.RequestTrackingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Main controller, get country LocationDto information
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@RestController
@RequestMapping("/location")
public class LocationController {

    /** Log information **/
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationController.class);

    /** Service with logic about calculate stats of requests **/
    private final DistanceStatsService statsService;

    /** Service with logic about finding information on Location of countries **/
    private final RequestTrackingService trackingService;

    /**
     * Main LocationDto controller constructor
     *
     * @param statsService Get stats about country, distance and invocations
     * @param trackingService information on Location of countries
     */
    public LocationController(final DistanceStatsService statsService, final RequestTrackingService trackingService) {

        this.statsService = statsService;
        this.trackingService = trackingService;
    }

    /**
     *
     * API used to display statistical information about requests made to the service.
     *
     * @return Statistical information on requests to the service
     */
    @GetMapping("/stats")
    public ResponseEntity<CountryStatsVo> stats() {

        LOGGER.info("initializes the statistics calculation process in controller");
        return ResponseEntity.status(HttpStatus.OK).body(statsService.getSummary());
    }

    /**
     *
     * API used to get tracking information about the country where the request is made
     *
     * @param ipVo Where the request starts
     * @return Tracking information
     */
    @PostMapping("/trace")
    public ResponseEntity<CountryTrackingVo> trace(@RequestBody final IpVo ipVo) {

        LOGGER.info("initialize request tracking process in controller");
        return ResponseEntity.status(HttpStatus.OK).body(trackingService.trace(ipVo.getIp()));
    }

}