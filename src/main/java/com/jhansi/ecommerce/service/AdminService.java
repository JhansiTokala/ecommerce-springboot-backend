package com.jhansi.ecommerce.service;

import com.jhansi.ecommerce.dto.DashboardResponse;
import com.jhansi.ecommerce.repository.OrderRepository;
import com.jhansi.ecommerce.repository.ProductRepository;
import com.jhansi.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public AdminService(
            UserRepository userRepository,
            ProductRepository productRepository,
            OrderRepository orderRepository) {

        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public DashboardResponse getDashboard() {

        DashboardResponse response =
                new DashboardResponse();

        response.setTotalUsers(
                userRepository.count());

        response.setTotalProducts(
                productRepository.count());

        response.setTotalOrders(
                orderRepository.count());

        response.setTotalRevenue(
                orderRepository.getTotalRevenue());

        return response;
    }
}