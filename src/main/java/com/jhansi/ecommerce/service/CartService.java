package com.jhansi.ecommerce.service;

import com.jhansi.ecommerce.repository.CartRepository;
import com.jhansi.ecommerce.repository.ProductRepository;
import com.jhansi.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.jhansi.ecommerce.dto.CartRequest;
import com.jhansi.ecommerce.entity.Cart;
import com.jhansi.ecommerce.entity.Product;
import com.jhansi.ecommerce.entity.User;
import java.util.List;
@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public CartService(
            CartRepository cartRepository,
            UserRepository userRepository,
            ProductRepository productRepository) {

        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }
    public Cart addToCart(CartRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        Cart cart = new Cart();

        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(request.getQuantity());

        return cartRepository.save(cart);
    }
    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();
    }
    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }
    public List<Cart> getCartByUser(Long userId) {

        return cartRepository.findByUserId(userId);
    }
    public Cart updateQuantity(
            Long cartId,
            Integer quantity) {

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() ->
                        new RuntimeException("Cart item not found"));

        cart.setQuantity(quantity);

        return cartRepository.save(cart);
    }
}