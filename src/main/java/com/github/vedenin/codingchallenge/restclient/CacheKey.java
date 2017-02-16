package com.github.vedenin.codingchallenge.restclient;

import com.github.vedenin.codingchallenge.common.CurrencyEnum;

import java.util.Calendar;

/**
 * Created by vvedenin on 2/16/2017.
 */
public class CacheKey {
    CurrencyEnum currencyFrom;
    CurrencyEnum currencyTo;
    Calendar calendar;

    public CacheKey(CurrencyEnum currencyFrom, CurrencyEnum currencyTo, Calendar calendar) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.calendar = calendar;
    }

    public CurrencyEnum getCurrencyFrom() {
        return currencyFrom;
    }

    public CurrencyEnum getCurrencyTo() {
        return currencyTo;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CacheKey cacheKey = (CacheKey) o;

        if (currencyFrom != cacheKey.currencyFrom) return false;
        if (currencyTo != cacheKey.currencyTo) return false;
        return calendar != null ? calendar.equals(cacheKey.calendar) : cacheKey.calendar == null;
    }

    @Override
    public int hashCode() {
        int result = currencyFrom != null ? currencyFrom.hashCode() : 0;
        result = 31 * result + (currencyTo != null ? currencyTo.hashCode() : 0);
        result = 31 * result + (calendar != null ? calendar.hashCode() : 0);
        return result;
    }
}
