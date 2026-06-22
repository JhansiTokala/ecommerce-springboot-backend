package com.jhansi.ecommerce.repository;

import com.jhansi.ecommerce.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository
        extends JpaRepository<Review, Long> {

    List<Review> findByProductId(Long productId);
    List<Review> findByRatingGreaterThanEqual(Integer rating);
}