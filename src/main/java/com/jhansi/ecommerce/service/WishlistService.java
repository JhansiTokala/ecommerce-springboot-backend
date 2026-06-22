package com.jhansi.ecommerce.service;

import com.jhansi.ecommerce.dto.WishlistRequest;
import com.jhansi.ecommerce.entity.Product;
import com.jhansi.ecommerce.entity.User;
import com.jhansi.ecommerce.entity.Wishlist;
import com.jhansi.ecommerce.repository.ProductRepository;
import com.jhansi.ecommerce.repository.UserRepository;
import com.jhansi.ecommerce.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public WishlistService(
            WishlistRepository wishlistRepository,
            UserRepository userRepository,
            ProductRepository productRepository) {

        this.wishlistRepository = wishlistRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Wishlist addToWishlist(
            WishlistRequest request) {

        User user = userRepository.findById(
                        request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Product product = productRepository.findById(
                        request.getProductId())
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        Wishlist wishlist = new Wishlist();

        wishlist.setUser(user);
        wishlist.setProduct(product);

        return wishlistRepository.save(wishlist);
    }

    public List<Wishlist> getWishlistByUserId(Long userId) {

        return wishlistRepository.findByUserId(userId);
    }

    public void deleteWishlist(Long id) {

        wishlistRepository.deleteById(id);
    }
}