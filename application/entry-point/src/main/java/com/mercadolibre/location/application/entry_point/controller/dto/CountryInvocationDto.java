/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Service invocations numbers by country
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryInvocationDto implements Serializable {

    /** Country name **/
    private String country;

    /** Distance between country and Buenos Aires **/
    private String distance;

    /** Invocations number **/
    private String invocations;

}