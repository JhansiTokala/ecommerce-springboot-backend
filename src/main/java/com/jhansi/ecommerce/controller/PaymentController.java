package com.jhansi.ecommerce.controller;

import com.jhansi.ecommerce.dto.PaymentRequest;
import com.jhansi.ecommerce.entity.Payment;
import com.jhansi.ecommerce.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(
            PaymentService paymentService) {

        this.paymentService = paymentService;
    }

    @PostMapping
    public Payment makePayment(
            @RequestBody PaymentRequest request) {

        return paymentService.makePayment(request);
    }
    @GetMapping
    public List<Payment> getAllPayments() {

        return paymentService.getAllPayments();
    }
    @GetMapping("/{id}")
    public Payment getPaymentById(
            @PathVariable Long id) {

        return paymentService.getPaymentById(id);
    }
    @GetMapping("/order/{orderId}")
    public Payment getPaymentByOrderId(
            @PathVariable Long orderId) {

        return paymentService
                .getPaymentByOrderId(orderId);
    }
}