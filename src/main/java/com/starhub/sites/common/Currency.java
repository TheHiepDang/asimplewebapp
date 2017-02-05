package com.starhub.sites.common;

public enum Currency {
    SGD("$"),
    EURO("€");

    private String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
