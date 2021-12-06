/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.data_provider.repository;

import com.mercadolibre.location.application.data_provider.model.CountryInformationModel;

import java.util.Map;

/**
 * Caching country invocation repository for
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
public interface CountryInformationRepository {

    /** Find all country invocations **/
    Map<String, CountryInformationModel> findAll();

    /** Find country invocations by countryName **/
    CountryInformationModel findByCountryName(final String countryName);

    /** Save a country invocation **/
    void save(final CountryInformationModel countryInvocation);

    /** Remove a country invocation by countryName **/
    void delete(final String countryName);

}