package com.jhansi.ecommerce.repository;

import com.jhansi.ecommerce.entity.Product;
import com.jhansi.ecommerce.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ProductRepository
        extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String keyword);
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByStockLessThan(Integer stock);
    List<Product> findByPriceBetween(
            Double min,
            Double max);
    long countByCategoryId(Long categoryId);

}