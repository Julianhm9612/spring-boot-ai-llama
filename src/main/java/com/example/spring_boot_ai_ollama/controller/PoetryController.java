package com.example.spring_boot_ai_ollama.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_ai_ollama.dto.PoetryDto;
import com.example.spring_boot_ai_ollama.service.PoetryService;

@RestController
@RequestMapping("ai")
public class PoetryController {
    private final PoetryService poetryService;

    public PoetryController(PoetryService poetryService) {
        this.poetryService = poetryService;
    }

    @GetMapping("/cathaiku")
    public ResponseEntity<String> generateHaiku(){
        return ResponseEntity.ok(poetryService.getCatHaiku());
    }

    @GetMapping("/poetry")
    public ResponseEntity<PoetryDto> generatePoetry(@RequestParam("genre") String genre, @RequestParam("theme") String theme) {
        return ResponseEntity.ok(poetryService.getPoetryByGenreAndTheme(genre, theme));
    }
}
