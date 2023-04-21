package com.aaron.little.shoppingcartexercise.Service;

import com.aaron.little.shoppingcartexercise.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartService {
    @Value("${store.tax.rate}")
    private double taxRate;

    public CalculatedReceipt calculateReceipt(Cart cart, CouponBook couponBook){

        Map<String,Double> couponItemMap = new HashMap<>();
        for(Coupon coupon : couponBook.getCoupons()){
            couponItemMap.put(coupon.getAppliedSku(),coupon.getDiscountPrice());
        }

        double subtotalBeforeDiscounts = 0.00;
        double discountTotal = 0.00;
        double taxTotal = 0.00;
        double taxableSubtotalAfterDiscounts= 0.00;

        for(Item item : cart.getItems()){
            subtotalBeforeDiscounts += item.getPrice();
            double itemDiscount = calculateTotalDiscounts(item, couponItemMap);
            discountTotal += itemDiscount;

            if(item.isTaxable()){
                if(itemDiscount > 0){
                    double newPrice = (item.getPrice() > itemDiscount) ? (item.getPrice() - itemDiscount) : 0;
                    item.setPrice(newPrice);
                }
                taxableSubtotalAfterDiscounts += item.getPrice();
                taxTotal += (item.getPrice() * taxRate);
            }
        }

        CalculatedReceipt calculatedReceipt = new CalculatedReceipt();
        calculatedReceipt.setSubTotalBeforeDiscounts(subtotalBeforeDiscounts);
        calculatedReceipt.setDiscountTotal(discountTotal);
        calculatedReceipt.setSubtotalAfterDiscounts(subtotalBeforeDiscounts-discountTotal);
        calculatedReceipt.setTaxTotal(taxTotal);
        calculatedReceipt.setTaxableSubtotalAfterDiscounts(taxableSubtotalAfterDiscounts);
        calculatedReceipt.setGrandTotal((subtotalBeforeDiscounts - discountTotal) + taxTotal);

        return calculatedReceipt;
    }

    private double calculateTotalDiscounts(Item item, Map<String,Double> couponItemMap ){
        double discount = 0;
        if(couponItemMap.containsKey(item.getSku())){
            double listedDiscount = couponItemMap.get(item.getSku());
            discount = (item.getPrice() > listedDiscount) ? listedDiscount : item.getPrice();
        }
        return discount;
    }
}
