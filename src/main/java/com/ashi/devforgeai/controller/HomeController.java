package com.ashi.devforgeai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, String> home() {

        return Map.of(
                "application", "DevForge AI",
                "status", "Running",
                "description", "AI-Powered Multi-Language Code Review Platform",
                "swagger", "/swagger-ui/index.html"
        );
    }
}