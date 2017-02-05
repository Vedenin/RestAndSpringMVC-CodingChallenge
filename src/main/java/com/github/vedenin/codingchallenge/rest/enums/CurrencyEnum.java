package com.github.vedenin.codingchallenge.rest.enums;

/**
 * Created by slava on 04.02.17.
 */
public enum CurrencyEnum {
    EUR("EUR"),
    USD("USD"),
    GBP("GBP"),
    NZD("NZD"),
    AUD("AUD"),
    JPY("JPY"),
    HUF("HUF"),
    RUB("RUB"),
    PLN("PLN");

    private final String name;

    CurrencyEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
