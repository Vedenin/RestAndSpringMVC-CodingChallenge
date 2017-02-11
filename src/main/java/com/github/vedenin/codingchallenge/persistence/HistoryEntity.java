package com.github.vedenin.codingchallenge.persistence;

import com.github.vedenin.codingchallenge.common.CurrencyEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by slava on 11.02.17.
 */
@Entity
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private BigDecimal amount;

    private CurrencyEnum currencyFrom;

    private CurrencyEnum currencyTo;

    private Date dateCreate;

    private BigDecimal result;

    public HistoryEntity(BigDecimal amount, CurrencyEnum currencyFrom, CurrencyEnum currencyTo, Date dateCreate, BigDecimal result) {
        this.amount = amount;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.dateCreate = dateCreate;
        this.result = result;
    }

    public HistoryEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CurrencyEnum getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(CurrencyEnum currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public CurrencyEnum getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(CurrencyEnum currencyTo) {
        this.currencyTo = currencyTo;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }
}
