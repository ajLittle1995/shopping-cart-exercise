package com.aaron.little.shoppingcartexercise.Model;

import java.math.BigDecimal;

public class CalculatedReceipt {
    private final static int TWO_DECIMAL_PLACES = 2;
    private double subTotalBeforeDiscounts;
    private double taxTotal;
    private double grandTotal;
    private double discountTotal;
    private double subtotalAfterDiscounts;
    private double taxableSubtotalAfterDiscounts;

    public double getSubTotalBeforeDiscounts() {
        return subTotalBeforeDiscounts;
    }

    public void setSubTotalBeforeDiscounts(double subTotal) {
        this.subTotalBeforeDiscounts = convertToUSDFormat(subTotal);;
    }

    public double getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = convertToUSDFormat(taxTotal);
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = convertToUSDFormat(grandTotal);
    }

    public double getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscountTotal(double discountTotal) {
        this.discountTotal = convertToUSDFormat(discountTotal);
    }

    public double getSubtotalAfterDiscounts() {
        return subtotalAfterDiscounts;
    }

    public void setSubtotalAfterDiscounts(double subtotalAfterDiscounts) {
        this.subtotalAfterDiscounts = convertToUSDFormat(subtotalAfterDiscounts);
    }

    public double getTaxableSubtotalAfterDiscounts() {
        return taxableSubtotalAfterDiscounts;
    }

    public void setTaxableSubtotalAfterDiscounts(double taxableSubtotalAfterDiscounts) {
        this.taxableSubtotalAfterDiscounts = convertToUSDFormat(taxableSubtotalAfterDiscounts);
    }

    private double convertToUSDFormat(double amount){
        return new BigDecimal(amount).setScale(TWO_DECIMAL_PLACES,BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }
}
