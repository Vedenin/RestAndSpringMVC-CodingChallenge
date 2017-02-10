package com.github.vedenin.codingchallenge.converter;

import com.github.vedenin.codingchallenge.common.CurrencyEnum;
import com.github.vedenin.codingchallenge.restclient.RestClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Created by vvedenin on 2/9/2017.
 */
@Service
public class CurrentConvectorDefault implements CurrentConvector {
    @Inject
    @Qualifier("FaultTolerant")
    RestClient restClient;


    @Override
    public BigDecimal getConvertValue(BigDecimal amount, CurrencyEnum currencyFrom, CurrencyEnum currencyTo) {
        return amount.multiply(restClient.getCurrentExchangeRates(currencyFrom, currencyTo));
    }
}
