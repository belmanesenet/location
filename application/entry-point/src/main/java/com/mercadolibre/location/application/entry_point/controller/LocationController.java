/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.controller;

import com.mercadolibre.location.application.entry_point.controller.vo.IpVo;
import com.mercadolibre.location.application.entry_point.controller.vo.StatsResponseVo;
import com.mercadolibre.location.application.entry_point.controller.vo.TraceResponseVo;
import com.mercadolibre.location.application.entry_point.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

    /** Service with logic about finding information on LocationDto of countries **/
    private final LocationService service;

    /**
     * Main LocationDto controller constructor
     *
     * @param service Starts the process of tracking and obtaining statistical information
     */
    public LocationController(final LocationService service) {

        this.service = service;
    }

    /**
     *
     * API used to display statistical information about requests made to the service.
     *
     * @return Statistical information on requests to the service
     */
    @GetMapping("/stats")
    public ResponseEntity<StatsResponseVo> stats() {

        LOGGER.info("initializes the statistics calculation process in controller");
        return ResponseEntity.status(HttpStatus.OK).body(service.stats());
    }

    /**
     *
     * API used to get tracking information about the country where the request is made
     *
     * @param ipVo Where the request starts
     * @return Tracking information
     */
    @PostMapping("/trace")
    public ResponseEntity<TraceResponseVo> trace(@RequestBody final IpVo ipVo) throws IOException {

        LOGGER.info("initialize request tracking process in controller");
        return ResponseEntity.status(HttpStatus.OK).body(service.trace(ipVo.getIp()));
    }

}