package com.jhansi.ecommerce.service;

import com.jhansi.ecommerce.dto.ReviewRequest;
import com.jhansi.ecommerce.entity.Product;
import com.jhansi.ecommerce.entity.Review;
import com.jhansi.ecommerce.entity.User;
import com.jhansi.ecommerce.repository.ProductRepository;
import com.jhansi.ecommerce.repository.ReviewRepository;
import com.jhansi.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public ReviewService(
            ReviewRepository reviewRepository,
            UserRepository userRepository,
            ProductRepository productRepository) {

        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Review addReview(ReviewRequest request) {

        User user = userRepository.findById(
                        request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Product product = productRepository.findById(
                        request.getProductId())
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        Review review = new Review();

        review.setUser(user);
        review.setProduct(product);
        review.setRating(request.getRating());
        review.setComment(request.getComment());

        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByProductId(Long productId) {

        return reviewRepository.findByProductId(productId);
    }

    public void deleteReview(Long id) {

        reviewRepository.deleteById(id);
    }
    public List<Review> getTopRatedProducts() {

        return reviewRepository
                .findByRatingGreaterThanEqual(4);
    }
}