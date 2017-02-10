package com.github.vedenin.codingchallenge.converter;

import com.github.vedenin.codingchallenge.common.CurrencyEnum;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by vvedenin on 2/9/2017.
 */
public interface CurrentConvector {
    BigDecimal getConvertValue(BigDecimal amount, CurrencyEnum currencyFrom, CurrencyEnum currencyTo);
    BigDecimal getConvertHistoricalValue(BigDecimal amount, CurrencyEnum currencyFrom, CurrencyEnum currencyTo, Calendar calendar);
}
