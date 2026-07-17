package com.ashi.devforgeai.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotBlank;


@Schema(description = "Request payload for AI code review")
public class ReviewRequest {


    @Schema(
    description = "Programming language of the submitted code",
    example = "Java"
    )
    @NotBlank(message = "Language is required")
    private String language;



    @Schema(
    description = "Source code to be reviewed by AI",
    example = "public class Main { public static void main(String[] args) { System.out.println(\"Hello\"); } }"
    )
    @NotBlank(message = "Code cannot be empty")
    private String code;

    public ReviewRequest() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}