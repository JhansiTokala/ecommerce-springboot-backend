package com.jhansi.ecommerce.controller;

import com.jhansi.ecommerce.dto.WishlistRequest;
import com.jhansi.ecommerce.entity.Wishlist;
import com.jhansi.ecommerce.service.WishlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(
            WishlistService wishlistService) {

        this.wishlistService = wishlistService;
    }

    @PostMapping
    public Wishlist addToWishlist(
            @RequestBody WishlistRequest request) {

        return wishlistService.addToWishlist(request);
    }

    @GetMapping("/user/{userId}")
    public List<Wishlist> getWishlistByUserId(
            @PathVariable Long userId) {

        return wishlistService.getWishlistByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteWishlist(
            @PathVariable Long id) {

        wishlistService.deleteWishlist(id);

        return "Wishlist Item Deleted Successfully";
    }
}