package com.ashi.devforgeai.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("DevForge AI API")
                        .description("AI-powered code review REST API built with Spring Boot and OpenRouter.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Ashi Kaushik")
                                .email("your-email@example.com")));
    }
}