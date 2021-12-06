/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:11 PM                     *
 ******************************************/
package com.mercadolibre.location.application.configuration.entry_point;

import com.mercadolibre.location.application.core.provider.DistanceStatsProvider;
import com.mercadolibre.location.application.core.provider.RequestTrackingProvider;
import com.mercadolibre.location.application.core.use_case.DistanceStatsUseCase;
import com.mercadolibre.location.application.core.use_case.RequestTrackingUseCase;
import com.mercadolibre.location.application.core.use_case.impl.DistanceStatsUseCaseImpl;
import com.mercadolibre.location.application.core.use_case.impl.RequestTrackingUseCaseImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Produces beans to be managed by the Spring container
 *
 * @author: <a href="mailto:belman.santos@payulatam.com"> belman </a>
 * @version: 1.1.0
 */
@Configuration
@ComponentScan("com.mercadolibre.location.application")
public class UseCasesInitializer {

	/**
	 * Build a valid {@link DistanceStatsUseCase} bean
	 *
	 * @param provider Provide a {@link DistanceStatsProvider} used in core layer
	 * @return a {@link DistanceStatsUseCase} built with its providers
	 */
	@Bean
	public DistanceStatsUseCase buildDistanceStatsUseCase(final DistanceStatsProvider provider) {

		return new DistanceStatsUseCaseImpl(provider);
	}

	/**
	 * Build a valid {@link RequestTrackingUseCase} bean
	 *
	 * @param provider Provide a {@link DistanceStatsProvider} used in core layer
	 * @return a {@link RequestTrackingUseCase} built with its providers
	 */
	@Bean
	public RequestTrackingUseCase buildRequestTrackingUseCase(final RequestTrackingProvider provider) {

		return new RequestTrackingUseCaseImpl(provider);
	}

}