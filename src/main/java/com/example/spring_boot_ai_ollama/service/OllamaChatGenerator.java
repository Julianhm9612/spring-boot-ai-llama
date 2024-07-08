package com.example.spring_boot_ai_ollama.service;

import java.util.Map;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class OllamaChatGenerator {

    private final OllamaChatModel ollamaChatModel;

    public OllamaChatGenerator(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    @SuppressWarnings("rawtypes")
    public Map generate(String message) {
        return Map.of("generation", this.ollamaChatModel.call(message));
    }
}
