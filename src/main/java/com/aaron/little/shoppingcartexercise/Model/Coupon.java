package com.aaron.little.shoppingcartexercise.Model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Coupon {

    private String couponName;

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getAppliedSku() {
        return appliedSku;
    }

    public void setAppliedSku(String appliedSku) {
        this.appliedSku = appliedSku;
    }

    public double getDiscountPrice() {
        return discountPrice.doubleValue();
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = new BigDecimal(discountPrice).setScale(2,BigDecimal.ROUND_HALF_DOWN);;
    }

    private String appliedSku;
    private BigDecimal discountPrice;
}
