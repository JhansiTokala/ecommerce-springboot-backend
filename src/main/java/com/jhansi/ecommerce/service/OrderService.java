package com.jhansi.ecommerce.service;

import com.jhansi.ecommerce.entity.*;
import com.jhansi.ecommerce.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

import com.jhansi.ecommerce.dto.OrderRequest;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final CouponRepository couponRepository;
    public OrderService(
            OrderRepository orderRepository,
            CartRepository cartRepository,
            UserRepository userRepository,
            OrderItemRepository orderItemRepository,
            ProductRepository productRepository,
            CouponRepository couponRepository) {

        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.couponRepository = couponRepository;
    }
    public Order placeOrder(OrderRequest request) {

        User user = userRepository.findById(
                        request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        List<Cart> cartItems =
                cartRepository.findByUserId(
                        request.getUserId());

        double total = 0;

        for (Cart cart : cartItems) {

            total += cart.getProduct().getPrice()
                    * cart.getQuantity();
        }
        if(request.getCouponCode() != null &&
                !request.getCouponCode().isEmpty()) {

            Coupon coupon =
                    couponRepository.findByCode(
                                    request.getCouponCode())
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Invalid Coupon"));

            total = total -
                    (total *
                            coupon.getDiscountPercentage()
                            / 100);
        }

        Order order = new Order();

        order.setUser(user);
        order.setTotalAmount(total);
        order.setStatus("PENDING");
        for (Cart cart : cartItems) {

            Product product = cart.getProduct();

            if(product.getStock() < cart.getQuantity()) {
                throw new RuntimeException(
                        product.getName() + " is out of stock");
            }

            product.setStock(
                    product.getStock() - cart.getQuantity());

            productRepository.save(product);
        }

        Order savedOrder = orderRepository.save(order);
        for (Cart cart : cartItems) {

            OrderItem orderItem = new OrderItem();

            orderItem.setOrder(savedOrder);
            orderItem.setProduct(cart.getProduct());
            orderItem.setQuantity(cart.getQuantity());
            orderItem.setPrice(cart.getProduct().getPrice());

            orderItemRepository.save(orderItem);
        }

        cartRepository.deleteAll(cartItems);

        return savedOrder;
    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Order getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));
    }
    public Order updateOrderStatus(
            Long orderId,
            String status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        order.setStatus(status);

        return orderRepository.save(order);
    }
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}