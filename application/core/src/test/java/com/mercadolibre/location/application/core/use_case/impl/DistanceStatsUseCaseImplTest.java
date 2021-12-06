/*******************************************
 * Mercadolibre - Copyright (c) ...        *
 * https://www.mercadolibre.com.co/        *
 * 29/11/21 - 03:02 PM                     *
 ******************************************/
package com.mercadolibre.location.application.core.use_case.impl;

import com.mercadolibre.location.application.core.provider.DistanceStatsProvider;
import com.mercadolibre.location.application.core.use_case.DistanceStatsUseCase;
import com.mercadolibre.location.application.core.use_case.entity.CountryInformationEntity;
import com.mercadolibre.location.application.core.use_case.entity.CountryStatsEntity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Tests the distance stats use case implementation
 *
 * @author: <a href="mailto:belman.santos@payulatam.com"> belman </a>
 * @version: 1.1.0
 */
@ExtendWith(MockitoExtension.class)
class DistanceStatsUseCaseImplTest {

    /** Simulates the use case behavior **/
    @Mock
    private DistanceStatsProvider provider;

    /** Object under test **/
    private DistanceStatsUseCase distanceStatsUseCase;

    /** Simulate the entity behavior **/
    private Map<String, CountryInformationEntity> countryInformationEntities;

    /**
     * This method will run before each {@link Test} annotated method.
     */
    @BeforeEach
    void setUp() {

        countryInformationEntities = fakeCountryInformationEntity();
        distanceStatsUseCase = new DistanceStatsUseCaseImpl(provider);
    }

    /**
     * scenario: When a valid configuration is received as argument, should return the same configuration
     */
    @Test
    @DisplayName("getSummary. When a valid provider is received as argument, should return a valid CountryStatsEntity")
    public void GetSummary_WhenAValidProviderIsReceivedAsArgument_ShouldReturnAValidCountryStatsEntity() {

        /*****| Arrange |*****/
        when(provider.getSummary()).thenReturn(countryInformationEntities);
        Map<String, CountryInformationEntity> countryInformationExpected = countryInformationEntities;

        /*****| Act |*****/
        CountryStatsEntity response = distanceStatsUseCase.getSummary();

        /*****| Assert |*****/
        assertEquals(response.getFarthestDistance(), Double.parseDouble(countryInformationExpected.get("Colombia").getDistance()));

    }

    /*******************************************************************************************************************
     *                                                    Utilities                                                    *
     ******************************************************************************************************************/

    /**
     * Country Stats entity fake
     *
     * @return a {@link CountryStatsEntity} for unit testing
     */
    private Map<String, CountryInformationEntity> fakeCountryInformationEntity() {

        Map<String, CountryInformationEntity> countryInformationEntities = new HashMap<>();

        CountryInformationEntity countryInformationEntity = new CountryInformationEntity();
        countryInformationEntity.setCountry("Colombia");
        countryInformationEntity.setDistance("10");
        countryInformationEntity.setInvocations("10");

        countryInformationEntities.put(countryInformationEntity.getCountry(), countryInformationEntity);

        return countryInformationEntities;
    }

    /**
     * This method will run after each {@link Test} annotated method.
     */
    @AfterEach
    void tearDown() {

        countryInformationEntities = null;
        provider = null;
    }

}