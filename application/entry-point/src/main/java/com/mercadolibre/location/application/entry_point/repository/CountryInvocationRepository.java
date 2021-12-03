/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.repository;

import com.mercadolibre.location.application.entry_point.controller.dto.CountryInvocationDto;

import java.util.Map;

/**
 * Caching country invocation repository for
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
public interface CountryInvocationRepository {

    /** Find all country invocations **/
    Map<String, CountryInvocationDto> findAll();

    /** Find country invocations by countryName **/
    CountryInvocationDto findByCountryName(final String countryName);

    /** Save a country invocation **/
    void save(final CountryInvocationDto countryInvocation);

    /** Remove a country invocation by countryName **/
    void delete(final String countryName);

}