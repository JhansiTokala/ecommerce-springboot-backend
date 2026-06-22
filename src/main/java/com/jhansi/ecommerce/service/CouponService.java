package com.jhansi.ecommerce.service;

import com.jhansi.ecommerce.dto.CouponRequest;
import com.jhansi.ecommerce.entity.Coupon;
import com.jhansi.ecommerce.repository.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public CouponService(
            CouponRepository couponRepository) {

        this.couponRepository = couponRepository;
    }

    public Coupon addCoupon(
            CouponRequest request) {

        if(couponRepository.findByCode(
                request.getCode()).isPresent()) {

            throw new RuntimeException(
                    "Coupon already exists");
        }

        Coupon coupon = new Coupon();

        coupon.setCode(request.getCode());
        coupon.setDiscountPercentage(
                request.getDiscountPercentage());

        return couponRepository.save(coupon);
    }

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }
}