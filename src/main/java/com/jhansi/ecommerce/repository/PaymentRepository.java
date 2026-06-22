package com.jhansi.ecommerce.repository;

import com.jhansi.ecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository
        extends JpaRepository<Payment, Long> {
    Payment findByOrderId(Long orderId);
}
