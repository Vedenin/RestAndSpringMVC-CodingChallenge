package com.github.vedenin.codingchallenge.restclient;

import com.github.vedenin.codingchallenge.common.CurrencyEnum;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * Created by slava on 10.02.17.
 */
@Service("FaultTolerant")
public class FaultTolerantRestClient implements RestClient {
    @Inject
    private List<RestClient> list;

    public BigDecimal getCurrentExchangeRates(CurrencyEnum currencyFrom, CurrencyEnum currencyTo) {
        for (RestClient client : list) {
            if (!(client instanceof FaultTolerantRestClient)) {
                try {
                    return client.getCurrentExchangeRates(currencyFrom, currencyTo);
                } catch (Exception ignore) {
                }
            }
        }
        return null;
    }

    public BigDecimal getHistoricalExchangeRates(CurrencyEnum currencyFrom, CurrencyEnum currencyTo, Calendar calendar) {
        for (RestClient client : list) {
            if (!(client instanceof FaultTolerantRestClient)) {
                try {
                    return client.getHistoricalExchangeRates(currencyFrom, currencyTo, calendar);
                } catch (Exception ignore) {
                }
            }
        }
        return null;
    }

}
