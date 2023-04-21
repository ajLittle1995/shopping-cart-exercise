package com.aaron.little.shoppingcartexercise.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class Item {
    private String itemName;
    private String sku;
    private boolean isTaxable;
    private boolean ownBrand;
    private BigDecimal price;
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    @JsonProperty("isTaxable")
    public boolean isTaxable() {
        return isTaxable;
    }

    public void setTaxable(boolean taxable) {
        isTaxable = taxable;
    }
    public boolean isOwnBrand() {
        return ownBrand;
    }
    public void setOwnBrand(boolean ownBrand) {
        this.ownBrand = ownBrand;
    }
    public double getPrice() {
        return price.doubleValue();
    }
    public void setPrice(double price) {
        this.price = new BigDecimal(price).setScale(2,BigDecimal.ROUND_HALF_DOWN);
    }
}
