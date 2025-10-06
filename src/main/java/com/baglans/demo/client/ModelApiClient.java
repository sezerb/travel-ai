package com.baglans.demo.client;


import org.springframework.stereotype.Component;
import dev.langchain4j.model.openai.OpenAiChatModel;

@Component
public class ModelApiClient {
    // Local Granite chat endpoint (exposes OpenAI-compatible /v1/chat/completions)
    private static final String BASE_URL = "http://localhost:50187";
    // New model id
    private static final String MODEL_NAME = "ibm-granite/granite-3.3-8b-instruct-GGUF";
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
