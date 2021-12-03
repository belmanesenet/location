/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 01/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Value object class that models the initial request
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Getter
@Setter
public class IpVo implements Serializable {

    /** IP of the country where the request starts **/
    private String ip;

}