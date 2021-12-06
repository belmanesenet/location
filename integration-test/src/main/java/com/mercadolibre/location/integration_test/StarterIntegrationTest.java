package com.mercadolibre.location.integration_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class that initialize the massive cancellation process
 *
 * @author: <a href="mailto:belman.santos@payulatam.com"> belman </a>
 * @version: 1.1.0
 */
@SpringBootApplication
public class StarterIntegrationTest {

    /**
     * Main method that initialize the massive cancellation process
     *
     * @param args Received as parameters when starting the process
     */
    public static void main( String[] args ) {

        SpringApplication.run(StarterIntegrationTest.class, args);
    }

}
