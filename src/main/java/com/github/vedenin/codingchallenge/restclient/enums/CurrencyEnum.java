package com.github.vedenin.codingchallenge.restclient.enums;

/**
 * Created by slava on 04.02.17.
 */
public enum CurrencyEnum {
    EUR("EUR", "Euro (EUR)"),
    USD("USD", "US Dollar (USD)"),
    GBP("GBP", "British Pound (GBP)"),
    NZD("NZD", "New Zealand Dollar (NZD)"),
    AUD("AUD", "Australian Dollar (AUD)"),
    JPY("JPY", "Japanese Yen (JPY)"),
    HUF("HUF", "Hungarian Forint (HUF)"),
    RUB("RUB", "Russian Ruble (RUB)"),
    PLN("PLN", "Polish Zloty (PLN)");
    private final String code;
    private final String description;

    CurrencyEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
