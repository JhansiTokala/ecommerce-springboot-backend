package com.jhansi.ecommerce.repository;

import com.jhansi.ecommerce.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository
        extends JpaRepository<Wishlist, Long> {

    List<Wishlist> findByUserId(Long userId);
}