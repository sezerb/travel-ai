package com.baglans.demo.controller;

import com.baglans.demo.service.RecommendationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecommendationController.class)
class RecommendationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecommendationService recommendationService;

    @Test
    void showForm_shouldReturnIndexView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void recommend_shouldReturnResultViewWithRecommendations() throws Exception {
        String place = "Paris";
        String expectedRecommendations = "Eiffel Tower, Louvre Museum, Notre-Dame Cathedral";
        
        when(recommendationService.getRecommendationSummary(place))
                .thenReturn(expectedRecommendations);

        mockMvc.perform(post("/recommend")
                        .param("place", place))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("place", place))
                .andExpect(model().attribute("summary", expectedRecommendations));
    }

    @Test
    void recommend_shouldHandleEmptyPlace() throws Exception {
        String place = "";
        String expectedRecommendations = "No recommendations found.";
        
        when(recommendationService.getRecommendationSummary(place))
                .thenReturn(expectedRecommendations);

        mockMvc.perform(post("/recommend")
                        .param("place", place))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("place", place))
                .andExpect(model().attribute("summary", expectedRecommendations));
    }
}
