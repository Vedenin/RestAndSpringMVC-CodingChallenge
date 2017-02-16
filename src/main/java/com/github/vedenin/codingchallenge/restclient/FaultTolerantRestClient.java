package com.github.vedenin.codingchallenge.restclient;

import com.github.vedenin.codingchallenge.common.CurrencyEnum;
import com.github.vedenin.codingchallenge.persistence.ErrorEntity;
import com.github.vedenin.codingchallenge.persistence.ErrorRepository;
import com.github.vedenin.codingchallenge.persistence.PropertyService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * Rest client that used all services before one of services not returns
 * correct result
 * <p>
 * Created by slava on 10.02.17.
 */
@Service("FaultTolerant")
public class FaultTolerantRestClient implements RestClient {
    @Inject
    private List<RestClient> list;
    @Inject
    private ErrorRepository errorRepository;
    @Inject
    private PropertyService propertyService;

    public BigDecimal getCurrentExchangeRates(CurrencyEnum currencyFrom, CurrencyEnum currencyTo) {
        for(int i = 0; i < propertyService.getDefaultProperties().getReplyRestTimes(); i++) {
            for (RestClient client : list) {
                try {
                    return client.getCurrentExchangeRates(currencyFrom, currencyTo);
                } catch (Exception exp) {
                    errorRepository.save(new ErrorEntity("Error when getCurrentExchangeRates, class: " +
                            client.getClass(), exp));
                }
            }
        }
        return null;
    }

    public BigDecimal getHistoricalExchangeRates(CurrencyEnum currencyFrom, CurrencyEnum currencyTo, Calendar calendar) {
        for(int i = 0; i < propertyService.getDefaultProperties().getReplyRestTimes(); i++) {
            for (RestClient client : list) {
                try {
                    return client.getHistoricalExchangeRates(currencyFrom, currencyTo, calendar);
                } catch (Exception exp) {
                    errorRepository.save(new ErrorEntity("Error when getCurrentExchangeRates, class: " +
                            client.getClass(), exp));
                }
            }
        }
        return null;
    }

}
