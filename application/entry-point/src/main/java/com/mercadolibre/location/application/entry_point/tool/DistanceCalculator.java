/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:11 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Calculate distance between 2 latitude longitude points
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Component
public class DistanceCalculator {

    /** Log information **/
    private static final Logger LOGGER = LoggerFactory.getLogger(DistanceCalculator.class);

    /** Buenos Aires latitude **/
    private static final Double BUENOS_AIRES_LATITUDE = Math.toRadians(-36.98713694251183);

    /** Buenos Aires longitude **/
    private static final Double BUENOS_AIRES_LONGITUDE = Math.toRadians(-60.166316948566184);

    public Double distanceToBuenosAires(Double latitudeTo, Double longitudeTo) {

        LOGGER.info("Calculate distance between {} y {} a Buenos Aires", latitudeTo, longitudeTo);
        /** The math module contains a function named toRadians which converts from degrees to radians.**/
        longitudeTo = Math.toRadians(longitudeTo);
        latitudeTo = Math.toRadians(latitudeTo);

        /** Haversine formula **/
        double distanceLongitude = longitudeTo - BUENOS_AIRES_LONGITUDE;
        double distanceLatitude = latitudeTo - BUENOS_AIRES_LATITUDE;
        double a = Math.pow(Math.sin(distanceLatitude / 2), 2)
                + Math.cos(BUENOS_AIRES_LATITUDE) * Math.cos(latitudeTo)
                * Math.pow(Math.sin(distanceLongitude / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        /** Radius of earth in kilometers. Use 3956 for miles **/
        double r = 6371;

        /** calculate the CurrencyExchangeDetailDto **/
        return(c * r);
    }

}