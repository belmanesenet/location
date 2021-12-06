/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 04:06 PM                     *
 ******************************************/
package com.mercadolibre.location.application.core.use_case.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Statistics about the use of the country LocationDto information service in core layer
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryStatsEntity implements Serializable {

    /** Farthest distance to Buenos Aires **/
    private Double farthestDistance;

    /** Closest distance to Buenos Aires **/
    private Double closestDistance;

    /** Average distance to Buenos Aires **/
    private Double averageDistance;

}