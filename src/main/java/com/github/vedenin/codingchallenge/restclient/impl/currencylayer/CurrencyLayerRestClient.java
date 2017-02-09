package com.github.vedenin.codingchallenge.restclient.impl.currencylayer;

import com.github.vedenin.codingchallenge.restclient.RestClient;
import com.github.vedenin.codingchallenge.common.CurrencyEnum;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.math.BigDecimal.ROUND_FLOOR;

/**
 * Created by slava on 04.02.17.
 */
@Service("CurrencyLayer")
public class CurrencyLayerRestClient implements RestClient {
    private final static String URL_LAST = "http://www.apilayer.net/api/live?format=1";
    private final static String URL_HISTORY = "http://apilayer.net/api/historical?date=";
    private final static String API_ID = "f7e5948888d41713110273b47c682db0";
    private final static String API_ID_PRM = "&access_key=";

    public static void main(String[] args) {
        RestClient restClient = new CurrencyLayerRestClient();
        BigDecimal convertRates = restClient.getCurrentExchangeRates(CurrencyEnum.EUR, CurrencyEnum.RUB);
        System.out.println(convertRates);
        convertRates = restClient.getHistoricalExchangeRates(CurrencyEnum.EUR, CurrencyEnum.RUB, new GregorianCalendar(2010, 10, 17));
        System.out.println(convertRates);

    }

    public BigDecimal getCurrentExchangeRates(CurrencyEnum currencyFrom, CurrencyEnum currencyTo) {
        return getExchangeRates(currencyFrom, currencyTo, getCurrentRates());
    }

    public BigDecimal getHistoricalExchangeRates(CurrencyEnum currencyFrom, CurrencyEnum currencyTo, Calendar calendar) {
        return getExchangeRates(currencyFrom, currencyTo, getHistoricalRates(calendar));
    }

    private BigDecimal getExchangeRates(CurrencyEnum currencyFrom, CurrencyEnum currencyTo, CurrencyLayerRatesContainer rates) {
        BigDecimal currencyFromRate = getRates(currencyFrom, rates);
        BigDecimal currencyToRate = getRates(currencyTo, rates);
        return currencyFromRate.divide(currencyToRate, 20, ROUND_FLOOR);
    }

    public CurrencyLayerRatesContainer getCurrentRates() {
        return getEntity(URL_LAST, API_ID, CurrencyLayerRatesContainer.class);
    }

    public CurrencyLayerRatesContainer getHistoricalRates(Calendar date) {
        return getEntity(URL_HISTORY + date.get(Calendar.YEAR) + "-" +
                        date.get(Calendar.MONTH) + "-" +
                        date.get(Calendar.DAY_OF_MONTH)
                , API_ID, CurrencyLayerRatesContainer.class);
    }


    private static BigDecimal getRates(CurrencyEnum currency, CurrencyLayerRatesContainer rates) {
        String rate = rates.getQuotes().get("USD" + currency.getCode());
        return new BigDecimal(rate);
    }

    private static <T> T getEntity(String url, String api, Class<T> entityClass) {
        Response response = null;
        try {
            Client client = ClientBuilder.newBuilder().build();
            response = client.target(url + API_ID_PRM + api).request().get();
            return response.readEntity(entityClass);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }


}