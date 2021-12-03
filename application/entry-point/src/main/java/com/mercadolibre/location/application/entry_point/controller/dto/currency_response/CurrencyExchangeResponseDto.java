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
 * Models the response of CurrencyDto exchange
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Getter
@Setter
public class CurrencyExchangeResponseDto implements Serializable {

    /** Contains CurrencyDto exchange information **/
    private CurrencyExchangeDetailDto result;

}