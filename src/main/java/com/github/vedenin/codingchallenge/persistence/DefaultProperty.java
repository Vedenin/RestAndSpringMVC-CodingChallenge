package com.github.vedenin.codingchallenge.persistence;

import com.github.vedenin.codingchallenge.common.CurrencyEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by slava on 16.02.17.
 */
@Entity
public class DefaultProperty {
    @Id
    private Long id = 1L;

    private String defaultCurrencyTo = CurrencyEnum.USD.getCode();
    private String defaultCurrencyFrom = CurrencyEnum.EUR.getCode();
    private BigDecimal defaultAmount = new BigDecimal(1.0);
    private Long cacheExpiredIsSeconds = 60L * 60L;
    private Long replyRestTimes = 3L;

    public String getDefaultCurrencyTo() {
        return defaultCurrencyTo;
    }

    public void setDefaultCurrencyTo(String defaultCurrencyTo) {
        this.defaultCurrencyTo = defaultCurrencyTo;
    }

    public String getDefaultCurrencyFrom() {
        return defaultCurrencyFrom;
    }

    public void setDefaultCurrencyFrom(String defaultCurrencyFrom) {
        this.defaultCurrencyFrom = defaultCurrencyFrom;
    }

    public BigDecimal getDefaultAmount() {
        return defaultAmount;
    }

    public void setDefaultAmount(BigDecimal defaultAmount) {
        this.defaultAmount = defaultAmount;
    }

    public Long getCacheExpiredIsSeconds() {
        return cacheExpiredIsSeconds;
    }

    public void setCacheExpiredIsSeconds(Long cacheExpiredIsSeconds) {
        this.cacheExpiredIsSeconds = cacheExpiredIsSeconds;
    }

    public Long getReplyRestTimes() {
        return replyRestTimes;
    }

    public void setReplyRestTimes(Long replyRestTimes) {
        this.replyRestTimes = replyRestTimes;
    }
}
