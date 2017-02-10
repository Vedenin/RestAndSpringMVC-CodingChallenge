package com.github.vedenin.codingchallenge;

import com.github.vedenin.codingchallenge.common.CurrencyEnum;
import com.github.vedenin.codingchallenge.restclient.RestClient;
import com.github.vedenin.codingchallenge.restclient.impl.currencylayer.CurrencyLayerRestClient;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

/**
 * Created by vvedenin on 2/10/2017.
 */

public class CurrencyLayerRestClientTest {
    @Test
    public void ExternalTest() {
        RestClient restClient = new CurrencyLayerRestClient();
        BigDecimal convertRates = restClient.getCurrentExchangeRates(CurrencyEnum.EUR, CurrencyEnum.RUB);
        Assert.assertTrue(convertRates.doubleValue() > 0.0);
        convertRates = restClient.getHistoricalExchangeRates(CurrencyEnum.EUR, CurrencyEnum.RUB, new GregorianCalendar(2010, 10, 17));
        Assert.assertEquals(convertRates.doubleValue(), 42.6, 0.5);
        convertRates = restClient.getHistoricalExchangeRates(CurrencyEnum.EUR, CurrencyEnum.RUB, new GregorianCalendar(2012, 1, 1));
        Assert.assertEquals(convertRates.doubleValue(), 39.7, 0.5);
    }

}
