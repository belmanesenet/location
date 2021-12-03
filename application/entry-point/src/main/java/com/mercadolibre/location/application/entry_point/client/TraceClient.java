/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 30/11/21 - 08:58 AM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.client;

import com.mercadolibre.location.application.entry_point.controller.dto.TraceIpInfoDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Declarative rest client for get trace information
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
public interface TraceClient {

    /** Get IP information **/
    @GET("/{ip}")
    Call<TraceIpInfoDto> trace(@Path("ip") String ip, @Query("access_key") String accessKey);

}