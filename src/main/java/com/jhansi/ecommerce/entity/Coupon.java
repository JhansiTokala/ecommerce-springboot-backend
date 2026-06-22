package com.jhansi.ecommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;
    private Double discountPercentage;

    public Coupon() {
    }

    // Generate Constructor
    // Generate Getters

    public Coupon(Long id, String code, Double discountPercentage) {
        this.id = id;
        this.code = code;
        this.discountPercentage = discountPercentage;
    }
    // Generate Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}