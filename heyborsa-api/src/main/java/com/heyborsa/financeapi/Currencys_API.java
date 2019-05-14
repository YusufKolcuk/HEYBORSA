package com.heyborsa.financeapi;

public interface Currencys_API {
    String getDate();
    String getName();
    float getBuyingPrice();
    float getSellingPrice();
    boolean isForex();
}