/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 01/12/21 - 08:58 AM                     *
 ******************************************/
package com.mercadolibre.location.application.data_provider.client;

import com.mercadolibre.location.application.data_provider.model.retrofit.CurrencyExchangeResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Declarative rest client for Currency exchange
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
public interface CurrencyClient {

    /** Get CurrencyDto exchange information **/
    @GET("/v1/quotes/{source}/{target}/json")
    Call<CurrencyExchangeResponseModel> exchange(
        @Path("source") String source,
        @Path("target") String target,
        @Query("quantity") String quantity,
        @Query("key") String key);

}