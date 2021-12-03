/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:11 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.controller.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Data transfer object with ip information
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */

@Getter
@Setter
public class TraceIpInfoDto implements Serializable {

    /** Country name **/
    @SerializedName("country_name")
    private String countryName;

    /** Country ISO 3166-1 alpha-2 **/
    @SerializedName("country_code")
    private String countryCode;

    /** Country Currency **/
    private CurrencyDto currency;

    /** IP of the country where the request starts **/
    private String ip;

    /** Country latitude point **/
    private String latitude;

    /** country language information **/
    private LocationDto location;

    /** Country longitude point **/
    private String longitude;

    /** Country time zone **/
    @SerializedName("time_zone")
    private TimeZoneDto timeZone;

}