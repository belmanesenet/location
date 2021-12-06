/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.mercadolibre.location.application.entry_point.controller.LocationController;
import com.mercadolibre.location.application.entry_point.controller.vo.IpVo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterIntegrationTest.class)
@AutoConfigureMockMvc
public class LocationControllerTest {

    /**
     * Massive cancellation controller path
     */
    private String PATH = "/location";

    /**
     * The instance of mock mvc
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * The instance {@link WebApplicationContext}
     */
    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * The instance of {@link LocationController}
     */
    @MockBean
    private LocationController locationController;

    @Before
    public void setUp(){

        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(locationController).build();

    }

    /**
     * Test method to validate the execute network configuration service
     *
     * @throws Exception if the mockMvc failed in the method perform
     */
    @Test
    public void configureTheNetwork_WithCorrectRequest() throws Exception{

        mockMvc.perform(post(PATH + "/trace").
            content(asJsonString(new IpVo("201.184.239.170"))).contentType(MediaType.APPLICATION_JSON).
            accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    /**
     * Test method to validate if the execute network configuration service failed if the request is null.
     *
     * @throws Exception if the mockMvc failed in the method perform
     */
    @Test
    public void configureTheNetwork_WithNullRequest() throws Exception{

        mockMvc.perform(post(PATH + "/trace").content(asJsonString(null)).
            contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
            andExpect(status().isBadRequest());

    }

/*******************************************************************************************************************
 *                                                    Utilities                                                    *
 ******************************************************************************************************************/

    /**
     * This utility is used to transform json as String
     * @param obj the object to process
     * @return the string mapped
     */
    public static String asJsonString(final Object obj) {

        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
