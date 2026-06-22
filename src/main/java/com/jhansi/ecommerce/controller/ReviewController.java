package com.jhansi.ecommerce.controller;

import com.jhansi.ecommerce.dto.ReviewRequest;
import com.jhansi.ecommerce.entity.Review;
import com.jhansi.ecommerce.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(
            ReviewService reviewService) {

        this.reviewService = reviewService;
    }

    @PostMapping
    public Review addReview(
            @RequestBody ReviewRequest request) {

        return reviewService.addReview(request);
    }

    @GetMapping("/product/{productId}")
    public List<Review> getReviewsByProductId(
            @PathVariable Long productId) {

        return reviewService.getReviewsByProductId(productId);
    }

    @DeleteMapping("/{id}")
    public String deleteReview(
            @PathVariable Long id) {

        reviewService.deleteReview(id);

        return "Review Deleted Successfully";
    }

    @GetMapping("/top-rated")
    public List<Review> getTopRatedProducts() {

        return reviewService.getTopRatedProducts();
    }
}