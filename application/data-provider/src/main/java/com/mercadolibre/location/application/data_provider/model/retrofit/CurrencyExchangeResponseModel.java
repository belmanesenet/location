/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.data_provider.model.retrofit;

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
public class CurrencyExchangeResponseModel implements Serializable {

    /** Contains CurrencyDto exchange information **/
    private CurrencyExchangeDetailModel result;

}