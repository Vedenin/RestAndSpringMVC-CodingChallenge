package com.github.vedenin.codingchallenge.converter;

import com.github.vedenin.codingchallenge.common.CurrencyEnum;
import com.github.vedenin.codingchallenge.exceptions.ConverterException;
import com.github.vedenin.codingchallenge.restclient.RestClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by vvedenin on 2/9/2017.
 */
@Service
public class CurrencyConvectorDefault implements CurrencyConvector {
    @Inject
    @Qualifier("FaultTolerant")
    RestClient restClient;


    private BigDecimal getConvertingCurrentValue(BigDecimal amount, CurrencyEnum currencyFrom, CurrencyEnum currencyTo) {
        return amount.multiply(restClient.getCurrentExchangeRates(currencyFrom, currencyTo));
    }

    private BigDecimal getConvertingHistoricalValue(BigDecimal amount, CurrencyEnum currencyFrom, CurrencyEnum currencyTo, Calendar calendar) {
        return amount.multiply(restClient.getHistoricalExchangeRates(currencyFrom, currencyTo, calendar));
    }

    @Override
    public BigDecimal getConvertingValue(Boolean isHistory, BigDecimal amount, CurrencyEnum currencyFrom,
                                         CurrencyEnum currencyTo, Calendar calendar) {
        if(isHistory) {
            if(calendar != null) {
                return getConvertingHistoricalValue(amount, currencyFrom, currencyTo, calendar);
            } else {
                throw new ConverterException("'Date' must be filled in historical convection");
            }
        } else {
            return getConvertingCurrentValue(amount, currencyFrom, currencyTo);
        }
    }

}
