/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:11 PM                     *
 ******************************************/
package com.mercadolibre.location.application.core.use_case.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;

/**
 * Value object class to country information requests
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */

@Getter
@Setter
public class CountryTrackingEntity implements Serializable {

    /** Country name **/
    private String countryName;

    /** Country iso code **/
    private String countryCode;

    /** Country CurrencyDto **/
    private String currency;

    /** Query date **/
    private String date;

    /** Distance between the country where it is consulted and Buenos Aires **/
    private String estimatedDistance;

    /** Request IP **/
    private String ip;

    /** Country language **/
    private Collection<CountryLanguageEntity> languages;

    /** Country time **/
    private String times;

}