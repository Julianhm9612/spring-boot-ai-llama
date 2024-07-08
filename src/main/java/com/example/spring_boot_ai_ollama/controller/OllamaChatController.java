package com.example.spring_boot_ai_ollama.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_ai_ollama.records.Payload;
import com.example.spring_boot_ai_ollama.service.OllamaChatGenerator;

@RestController
@RequestMapping("/api/v1")
public class OllamaChatController {

    private final OllamaChatGenerator ollamaChatGenerator;

    public OllamaChatController(OllamaChatGenerator ollamaChatGenerator) {
        this.ollamaChatGenerator = ollamaChatGenerator;
    }

    @SuppressWarnings("rawtypes")
    @PostMapping(value = "/chat", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map chat(@RequestBody Payload payload){
        return this.ollamaChatGenerator.generate(payload.strings());
    }
}
