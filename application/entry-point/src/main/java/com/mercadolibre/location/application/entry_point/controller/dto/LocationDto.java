/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:11 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;

/**
 * Data transfer object with ip LanguageDto
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Getter
@Setter
public class LocationDto implements Serializable {

    /** Country LanguageDto **/
    private Collection<LanguageDto> languages;

}