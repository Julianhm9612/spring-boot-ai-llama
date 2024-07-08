package com.example.spring_boot_ai_ollama.service;

import java.util.List;
import java.util.Map;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

import com.example.spring_boot_ai_ollama.records.Payload;

@Service
public class OllamaEmbeddingsGenerator {
    private final EmbeddingModel embeddingModel;

    public OllamaEmbeddingsGenerator(EmbeddingModel embeddingModel) {
        this.embeddingModel = embeddingModel;
    }

    public EmbeddingResponse getEmbeddingsWithModelOverride(Payload payload) {
        return this.embeddingModel.call(new EmbeddingRequest(
                List.of(payload.strings()),
                OllamaOptions.create().withModel("mistral")));
    }

    public Map<String, EmbeddingResponse> getEmbeddingsWithDefaultModel(Payload payload) {
        EmbeddingResponse embeddingResponse = this.embeddingModel.embedForResponse(
                List.of(payload.strings()));
        return Map.of("embedding", embeddingResponse);
    }
}
