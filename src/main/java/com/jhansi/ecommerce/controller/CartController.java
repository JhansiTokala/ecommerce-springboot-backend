package com.jhansi.ecommerce.controller;

import com.jhansi.ecommerce.dto.CartRequest;
import com.jhansi.ecommerce.entity.Cart;
import com.jhansi.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Cart addToCart(
            @RequestBody CartRequest request) {

        return cartService.addToCart(request);
    }

    @GetMapping
    public List<Cart> getAllCartItems() {
        return cartService.getAllCartItems();
    }

    @DeleteMapping("/{id}")
    public String removeFromCart(
            @PathVariable Long id) {

        cartService.removeFromCart(id);

        return "Item Removed From Cart";
    }
    @GetMapping("/user/{userId}")
    public List<Cart> getCartByUser(
            @PathVariable Long userId) {

        return cartService.getCartByUser(userId);
    }
    @PutMapping("/{cartId}/{quantity}")
    public Cart updateQuantity(
            @PathVariable Long cartId,
            @PathVariable Integer quantity) {

        return cartService.updateQuantity(
                cartId,
                quantity
        );
    }
}