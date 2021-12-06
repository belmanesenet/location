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
 * Models Currency exchange information
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Getter
@Setter
public class CurrencyExchangeDetailModel implements Serializable {

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