package com.baglans.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baglans.demo.client.ModelApiClient;

@Service
public class RecommendationService {
    @Autowired
    private ModelApiClient modelApiClient;

    public String getRecommendationSummary(String place) {
        String response = modelApiClient.getRecommendations(place);
        if (response == null || response.isEmpty()) {
            return "No recommendations found.";
        }
        return response;
    }
}
