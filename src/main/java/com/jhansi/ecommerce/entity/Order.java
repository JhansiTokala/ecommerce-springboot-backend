package com.jhansi.ecommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalAmount;

    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order() {
    }

    public Order(Long id,
                 Double totalAmount,
                 String status,
                 User user) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.status = status;
        this.user = user;
    }

    // Generate Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}