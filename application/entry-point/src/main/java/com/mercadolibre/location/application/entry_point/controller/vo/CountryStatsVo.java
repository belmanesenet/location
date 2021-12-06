/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 04:06 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.controller.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Statistics about the use of the country LocationDto information service
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryStatsVo implements Serializable {

    /** Farthest distance to Buenos Aires **/
    @JsonProperty("farthest_distance")
    private Double farthestDistance;

    /** Closest distance to Buenos Aires **/
    @JsonProperty("closest_distance")
    private Double closestDistance;

    /** Average distance to Buenos Aires **/
    @JsonProperty("average_distance")
    private Double averageDistance;

}