/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:11 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Data transfer object with ip LanguageDto detail
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Getter
@Setter
public class LanguageDto implements Serializable {

    /** Language code **/
    private String code;

    /** Language name **/
    private String name;

}