/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:11 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.controller.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.location.application.entry_point.controller.dto.LanguageDto;
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
public class TraceResponseVo implements Serializable {

    /** Country name **/
    @JsonProperty("country_name")
    private String countryName;

    /** Country iso code **/
    @JsonProperty("country_code")
    private String countryCode;

    /** Country CurrencyDto **/
    private String currency;

    /** Query date **/
    private String date;

    /** Distance between the country where it is consulted and Buenos Aires **/
    @JsonProperty("estimated_distance")
    private String estimatedDistance;

    /** Request IP **/
    private String ip;

    /** Country language **/
    private Collection<LanguageDto> languages;

    /** Country time **/
    private String times;

}