/*******************************************
 * PayU Latam - Copyright (c) 2013 - 2017  *
 * http://www.payulatam.com                *
 * 12/5/19 - 4:20 PM                       *
 ******************************************/
package com.mercadolibre.location.application.data_provider.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Read page properties used for get cancellation request and cancellation summaries
 *
 * @author: <a href="mailto:belman.santos@payulatam.com"> belman </a>
 * @version: 1.1.0
 */
@Data
@Component
@EnableConfigurationProperties
@ConfigurationProperties("retrofit")
public class RetrofitProperty {

	/** Retrofit trace url **/
	private String traceUrl;

	/** Retrofit trace Key **/
	private String traceKey;

	/** Retrofit currency url **/
	private String currencyUrl;

	/** Retrofit currency key **/
	private String currencyKey;

}