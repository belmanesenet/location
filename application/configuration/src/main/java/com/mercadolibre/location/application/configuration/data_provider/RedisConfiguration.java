/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.configuration.data_provider;

import com.mercadolibre.location.application.data_provider.model.redis.CountryInformationModel;
import com.mercadolibre.location.application.data_provider.repository.CountryInformationRedisRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis connection and template configuration
 *
 * @author: <a href="mailto:belmanese@gmail.com"> belman </a>
 * @version: 1.0.0
 */
@Configuration
public class RedisConfiguration {

    /** Log information **/
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisConfiguration.class);

    /**
     * Configure a connection factory
     *
     * @return Connection factory type
     */
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {

        LOGGER.info("Configure a connection factory");
        return new JedisConnectionFactory();
    }

    /**
     * Configure key/value pairs template
     *
     * @return a template with key and value pairs
     */
//    @Bean
//    RedisTemplate<String, CountryInvocationDto> redisTemplate() {
//
//        LOGGER.info("Configure a redis template");
//        final RedisTemplate<String, CountryInvocationDto> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(jedisConnectionFactory());
//
//        return redisTemplate;
//    }

    /**
     * Configure key/value pairs template
     *
     * @return a template with key and value pairs
     */
    @Bean
    RedisTemplate<String, CountryInformationModel> redisTemplateModel() {

        LOGGER.info("Configure a redis template");
        final RedisTemplate<String, CountryInformationModel> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());

        return redisTemplate;
    }

    /**
     * Build a valid {@link CountryInformationRedisRepository} bean
     *
     * @return a {@link CountryInformationRedisRepository} built with its providers
     */
    @Bean
    public CountryInformationRedisRepository buildCountryInformationRedisRepository() {

        return new CountryInformationRedisRepository(redisTemplateModel());
    }




/** Heroku **/

//    @Bean
//    public RedisTemplate<String, CountryInvocationDto> redisTemplate(RedisConnectionFactory connectionFactory) {
//
//        LOGGER.info("Configure a redis template");
//        RedisTemplate<String, CountryInvocationDto> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//
//        return template;
//    }

}