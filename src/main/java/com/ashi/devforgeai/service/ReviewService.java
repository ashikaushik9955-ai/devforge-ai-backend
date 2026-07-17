package com.ashi.devforgeai.service;

import com.ashi.devforgeai.dto.ReviewRequest;
import com.ashi.devforgeai.dto.ReviewResponse;
import com.ashi.devforgeai.entity.Review;
import com.ashi.devforgeai.repository.ReviewRepository;
import org.springframework.stereotype.Service;


import com.ashi.devforgeai.ai.OpenRouterService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final OpenRouterService openRouterService;

    public ReviewService(ReviewRepository reviewRepository , OpenRouterService openRouterService) {
        this.reviewRepository = reviewRepository;
        this.openRouterService = openRouterService;
    }

    public ReviewResponse generateReview(ReviewRequest request) {

        Review review = new Review();

        review.setLanguage(request.getLanguage());
        review.setCode(request.getCode());



        String aiReview = openRouterService.reviewCode(
        request.getLanguage(),
        request.getCode()
);
        review.setReview(aiReview);

        review.setCreatedAt(LocalDateTime.now());

        reviewRepository.save(review);

        return new ReviewResponse(review.getReview());
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

}