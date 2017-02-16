package com.github.vedenin.codingchallenge.restclient;

import com.github.vedenin.codingchallenge.common.CurrencyEnum;
import com.github.vedenin.codingchallenge.persistence.ErrorEntity;
import com.github.vedenin.codingchallenge.persistence.ErrorRepository;
import com.github.vedenin.codingchallenge.persistence.PropertyService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Rest client that used all services before one of services not returns
 * correct result
 * <p>
 * Created by slava on 10.02.17.
 */
@Service("FaultTolerant")
public class FaultTolerantRestClient implements RestClient {
    private static final long INIT_DURATION = 60L * 60L;
    @Inject
    private List<RestClient> list;
    @Inject
    private ErrorRepository errorRepository;
    @Inject
    private PropertyService propertyService;
    private Cache<CacheKey, BigDecimal> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(INIT_DURATION, TimeUnit.SECONDS).build();
    private Long cacheDuration = INIT_DURATION;

    public BigDecimal getCurrentExchangeRates(CurrencyEnum currencyFrom, CurrencyEnum currencyTo) {
        reInitCache();
        CacheKey data = new CacheKey(currencyFrom, currencyTo, null);
        BigDecimal result = cache.getIfPresent(data);
        if(result != null) {
            return result;
        }
        for(int i = 0; i < propertyService.getDefaultProperties().getReplyRestTimes(); i++) {
            for (RestClient client : list) {
                try {
                    result = client.getCurrentExchangeRates(currencyFrom, currencyTo);
                    if(result != null) {
                        cache.put(data, result);
                        return result;
                    }
                } catch (Exception exp) {
                    errorRepository.save(new ErrorEntity("Error when getCurrentExchangeRates, class: " +
                            client.getClass(), exp));
                }
            }
        }
        return null;
    }

    public BigDecimal getHistoricalExchangeRates(CurrencyEnum currencyFrom, CurrencyEnum currencyTo, Calendar calendar) {
        reInitCache();
        CacheKey data = new CacheKey(currencyFrom, currencyTo, calendar);
        BigDecimal result = cache.getIfPresent(data);
        if(result != null) {
            return result;
        }
        for(int i = 0; i < propertyService.getDefaultProperties().getReplyRestTimes(); i++) {
            for (RestClient client : list) {
                try {
                    result = client.getHistoricalExchangeRates(currencyFrom, currencyTo, calendar);
                    if(result != null) {
                        cache.put(data, result);
                        return result;
                    }
                } catch (Exception exp) {
                    errorRepository.save(new ErrorEntity("Error when getCurrentExchangeRates, class: " +
                            client.getClass(), exp));
                }
            }
        }
        return null;
    }

    private void reInitCache() {
        Long newCacheDuration = propertyService.getDefaultProperties().getCacheExpiredIsSeconds();
        if(newCacheDuration != null && !cacheDuration.equals(newCacheDuration)) {
            cache = CacheBuilder.newBuilder()
                    .expireAfterWrite(newCacheDuration, TimeUnit.SECONDS).build();
            cacheDuration = newCacheDuration;
        }
    }
}
