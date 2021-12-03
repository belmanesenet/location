/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class that initialize the tracking process
 *
 * @author Belman Julio Santos (belmanese@gmail.com)
 * @version 1.0.0
 */
@SpringBootApplication
public class Starter {

    /**
     * Service main method
     *
     * @param args Received as parameters when starting the process
     */
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }

}