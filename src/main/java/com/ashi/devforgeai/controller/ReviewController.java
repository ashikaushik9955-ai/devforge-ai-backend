package com.ashi.devforgeai.controller;

import com.ashi.devforgeai.dto.ReviewRequest;
import com.ashi.devforgeai.dto.ReviewResponse;
import com.ashi.devforgeai.entity.Review;
import com.ashi.devforgeai.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;




@Tag(
    name = "AI Code Review API",
    description = "Endpoints for generating and retrieving AI-powered code reviews."
)



@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @Operation(
    summary = "Generate AI Code Review",
    description = "Accepts source code and programming language, generates an AI review, and stores it in the database."
    )
    @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Review generated successfully"),
    @ApiResponse(responseCode = "400", description = "Invalid request"),
    @ApiResponse(responseCode = "500", description = "AI service unavailable")
    })

    @PostMapping
    public ReviewResponse generateReview(@Valid @RequestBody ReviewRequest request) {
        return reviewService.generateReview(request);
    }




    @Operation(
    summary = "Get All Reviews",
    description = "Returns all AI-generated code reviews stored in the database."
    )
    @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Reviews fetched successfully")
    })

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
}