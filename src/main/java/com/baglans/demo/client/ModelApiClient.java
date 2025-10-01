package com.baglans.demo.client;


import org.springframework.stereotype.Component;
import dev.langchain4j.model.openai.OpenAiChatModel;

@Component
public class ModelApiClient {
    private static final String BASE_URL = "http://localhost:12434/engines/v1";
    private static final String MODEL_NAME = "ai/llama3.2:latest";
    private final OpenAiChatModel model;

    public ModelApiClient() {
        this.model = OpenAiChatModel.builder()
            .baseUrl(BASE_URL)
            .modelName(MODEL_NAME)
            .build();
    }

    public String getRecommendations(String place) {
        String prompt = "Recommend the best places to visit in " + place + " without any additional commentary.";
        return model.chat(prompt);
    }
}
