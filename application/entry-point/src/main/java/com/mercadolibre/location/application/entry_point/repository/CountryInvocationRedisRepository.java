/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.entry_point.repository;

import com.mercadolibre.location.application.entry_point.controller.dto.CountryInvocationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Country invocation redis repository
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Repository
public class CountryInvocationRedisRepository implements CountryInvocationRepository {

    /** Log information **/
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryInvocationRedisRepository.class);

    /** Caching redis key **/
    private static final String KEY = "invocations";

    /** Caching redis template **/
    private final  RedisTemplate<String, CountryInvocationDto> redisTemplate;

    /** Isolate operations **/
    private HashOperations hashOperations;

    public CountryInvocationRedisRepository(final RedisTemplate<String, CountryInvocationDto> redisTemplate) {

        this.redisTemplate = redisTemplate;
    }

    /**
     * Initialize operations using the template
     */
    @PostConstruct
    private void init() {

        hashOperations = redisTemplate.opsForHash();
    }

    /**
     * Find all country invocations
     *
     * @return Map with key/values country invocations cached
     */
    @Override
    public Map<String, CountryInvocationDto> findAll() {

        LOGGER.info("Find all invocations to the service");
        return hashOperations.entries(KEY);
    }

    /**
     * Find country invocations by countryName
     *
     * @param countryName to find country invocations
     * @return Country invocations founds
     */
    @Override
    public CountryInvocationDto findByCountryName(final String countryName) {

        LOGGER.info("Find invocations to the service by countryName {}", countryName);
        return (CountryInvocationDto) hashOperations.get(KEY, countryName);
    }

    /**
     * Caches a country invocation
     *
     * @param countryInvocation for save
     */
    @Override
    public void save(final CountryInvocationDto countryInvocation) {

        LOGGER.info("Update a country invocation to the service");
        hashOperations.put(KEY, countryInvocation.getCountry(), countryInvocation);
    }

    /**
     * Remove a country invocation by countryName
     * @param countryName for remove
     */
    @Override
    public void delete(final String countryName) {

        LOGGER.info("Remove invocations to the service by countryName {}", countryName);
        hashOperations.delete(KEY, countryName);
    }

}