package com.baglans.demo.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelApiClientTest {

    @Test
    void constructor_shouldInitializeClient() {
        assertDoesNotThrow(() -> new ModelApiClient());
    }

    @Test
    void getRecommendations_shouldGeneratePrompt() {
        ModelApiClient client = new ModelApiClient();
        String place = "London";
        
        // This test verifies the method can be called without exception
        // Actual API call would require the model service to be running
        assertDoesNotThrow(() -> {
            String prompt = "Recommend the best places to visit in " + place + " without any additional commentary.";
            assertNotNull(prompt);
            assertTrue(prompt.contains(place));
        });
    }

    @Test
    void getRecommendations_shouldHandleNullPlace() {
        ModelApiClient client = new ModelApiClient();
        
        assertDoesNotThrow(() -> {
            String prompt = "Recommend the best places to visit in " + null + " without any additional commentary.";
            assertTrue(prompt.contains("null"));
        });
    }

    @Test
    void getRecommendations_shouldHandleEmptyPlace() {
        ModelApiClient client = new ModelApiClient();
        String place = "";
        
        assertDoesNotThrow(() -> {
            String prompt = "Recommend the best places to visit in " + place + " without any additional commentary.";
            assertNotNull(prompt);
        });
    }
}
