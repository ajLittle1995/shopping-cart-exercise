package com.aaron.little.shoppingcartexercise.Controller;

import com.aaron.little.shoppingcartexercise.Model.CalculatedReceipt;
import com.aaron.little.shoppingcartexercise.Model.Cart;
import com.aaron.little.shoppingcartexercise.Service.CouponRetrieverService;
import com.aaron.little.shoppingcartexercise.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private CouponRetrieverService couponRetrieverService;

    @PostMapping("/calculateReceipt")
    public CalculatedReceipt calculateReceipt(@RequestBody Cart cart ){
        return shoppingCartService.calculateReceipt(cart, couponRetrieverService.getCouponBook());
    }
}
