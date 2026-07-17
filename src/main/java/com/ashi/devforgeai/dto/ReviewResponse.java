package com.ashi.devforgeai.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response containing AI-generated code review")
public class ReviewResponse {


    @Schema(
    description = "AI-generated review and suggestions",
    example = "Your code is readable. Consider using meaningful variable names and adding exception handling."
    )
    private String review;

    public ReviewResponse() {
    }

    public ReviewResponse(String review) {
        this.review = review;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
} 