package com.aaron.little.shoppingcartexercise.Service;


import com.aaron.little.shoppingcartexercise.Model.CouponBook;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CouponRetrieverService {

    @Value("${coupons.json.string}")
    private String couponsJson;

    private CouponBook couponBook;

    @PostConstruct
    public void init() throws Exception {
            ObjectMapper mapper = new ObjectMapper();
            this.couponBook = mapper.readValue(couponsJson, CouponBook.class);
    }
    public CouponBook getCouponBook() {
        return couponBook;
    }
}
