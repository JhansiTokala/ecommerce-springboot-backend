package com.jhansi.ecommerce.controller;

import com.jhansi.ecommerce.dto.OrderRequest;
import com.jhansi.ecommerce.dto.OrderStatusRequest;
import com.jhansi.ecommerce.entity.Order;
import com.jhansi.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(
            OrderService orderService) {

        this.orderService = orderService;
    }

    @PostMapping
    public Order placeOrder(
            @RequestBody OrderRequest request) {

        return orderService.placeOrder(request);
    }
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    @GetMapping("/{id}")
    public Order getOrderById(
            @PathVariable Long id) {

        return orderService.getOrderById(id);
    }
    @PutMapping("/{id}/status")
    public Order updateOrderStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return orderService.updateOrderStatus(id, status);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(
            @PathVariable Long userId) {

        return orderService.getOrdersByUserId(userId);
    }
}