package com.jhansi.ecommerce.controller;

import com.jhansi.ecommerce.dto.CouponRequest;
import com.jhansi.ecommerce.entity.Coupon;
import com.jhansi.ecommerce.service.CouponService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    private final CouponService couponService;

    public CouponController(
            CouponService couponService) {

        this.couponService = couponService;
    }

    @PostMapping
    public Coupon addCoupon(
            @RequestBody CouponRequest request) {

        return couponService.addCoupon(request);
    }

    @GetMapping
    public List<Coupon> getAllCoupons() {

        return couponService.getAllCoupons();
    }
}