package com.jhansi.ecommerce.service;

import com.jhansi.ecommerce.dto.PaymentRequest;
import com.jhansi.ecommerce.entity.Order;
import com.jhansi.ecommerce.entity.Payment;
import com.jhansi.ecommerce.repository.OrderRepository;
import com.jhansi.ecommerce.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentService(
            PaymentRepository paymentRepository,
            OrderRepository orderRepository) {

        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    public Payment makePayment(
            PaymentRequest request) {

        Order order = orderRepository.findById(
                        request.getOrderId())
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        Payment payment = new Payment();

        payment.setOrder(order);
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(
                request.getPaymentMethod());

        payment.setPaymentStatus("SUCCESS");

        payment.setTransactionId(
                UUID.randomUUID().toString());

        order.setStatus("PAID");

        orderRepository.save(order);

        return paymentRepository.save(payment);
    }
    public List<Payment> getAllPayments() {

        return paymentRepository.findAll();
    }
    public Payment getPaymentById(Long id) {

        return paymentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Payment not found"));
    }
    public Payment getPaymentByOrderId(
            Long orderId) {

        return paymentRepository
                .findByOrderId(orderId);
    }
}