/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.controller.dto.currency_response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Models CurrencyDto exchange information
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Getter
@Setter
public class CurrencyExchangeDetailDto implements Serializable {

    /** Update exchange **/
    private String updated;

    /** Exchange source **/
    private String source;

    /** Exchange target **/
    private String target;

    /** Exchange value **/
    private Double value;

    /** Exchange quantity **/
    private Double quantity;

    /** Exchange amount **/
    private Double amount;

}
