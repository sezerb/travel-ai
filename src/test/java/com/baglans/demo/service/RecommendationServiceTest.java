package com.baglans.demo.service;

import com.baglans.demo.client.ModelApiClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecommendationServiceTest {

    @Mock
    private ModelApiClient modelApiClient;

    @InjectMocks
    private RecommendationService recommendationService;

    @Test
    void getRecommendationSummary_shouldReturnRecommendations_whenClientReturnsValidResponse() {
        String place = "Tokyo";
        String expectedResponse = "Tokyo Tower, Senso-ji Temple, Meiji Shrine";
        
        when(modelApiClient.getRecommendations(place)).thenReturn(expectedResponse);

        String result = recommendationService.getRecommendationSummary(place);

        assertEquals(expectedResponse, result);
    }

    @Test
    void getRecommendationSummary_shouldReturnNoRecommendationsMessage_whenClientReturnsNull() {
        String place = "UnknownPlace";
        
        when(modelApiClient.getRecommendations(place)).thenReturn(null);

        String result = recommendationService.getRecommendationSummary(place);

        assertEquals("No recommendations found.", result);
    }

    @Test
    void getRecommendationSummary_shouldReturnNoRecommendationsMessage_whenClientReturnsEmptyString() {
        String place = "UnknownPlace";
        
        when(modelApiClient.getRecommendations(place)).thenReturn("");

        String result = recommendationService.getRecommendationSummary(place);

        assertEquals("No recommendations found.", result);
    }

    @Test
    void getRecommendationSummary_shouldHandleWhitespaceResponse() {
        String place = "SomePlace";
        String whitespaceResponse = "   ";
        
        when(modelApiClient.getRecommendations(place)).thenReturn(whitespaceResponse);

        String result = recommendationService.getRecommendationSummary(place);

        assertEquals(whitespaceResponse, result);
    }
}
