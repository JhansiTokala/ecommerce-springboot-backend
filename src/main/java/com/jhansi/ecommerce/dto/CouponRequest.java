package com.jhansi.ecommerce.dto;

public class CouponRequest {

    private String code;
    private Double discountPercentage;

    public CouponRequest() {
    }

    // Generate Getters and Setters

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