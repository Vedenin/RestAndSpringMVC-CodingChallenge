package com.github.vedenin.codingchallenge.rest;

import com.github.vedenin.codingchallenge.rest.enums.CurrencyEnum;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by slava on 04.02.17.
 */
public interface RestClient {
    BigDecimal getCurrentExchangeRates(CurrencyEnum currecnyFrom, CurrencyEnum currecnyTo);
    BigDecimal getHistoricalExchangeRates(CurrencyEnum currencyFrom, CurrencyEnum currencyTo, Calendar calendar);
}
