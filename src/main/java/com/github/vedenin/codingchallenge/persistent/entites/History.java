package com.github.vedenin.codingchallenge.persistent.entites;

import com.github.vedenin.codingchallenge.restclient.enums.CurrencyEnum;

import java.math.BigDecimal;

/**
 * Created by slava on 05.02.17.
 */
public class History {
    private Long userId;
    private CurrencyEnum currencyFrom;
    private CurrencyEnum currencyTo;
    private BigDecimal amount;
    private BigDecimal amountConverted;
}
