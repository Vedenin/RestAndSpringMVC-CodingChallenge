package com.github.vedenin.codingchallenge.mvc.model;

import com.github.vedenin.codingchallenge.common.CurrencyEnum;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Model for converter page
 *
 * Created by vvedenin on 2/8/2017.
 */
public class ConverterFormModel {
    @NotNull
    private String to = CurrencyEnum.USD.getCode();
    @NotNull
    private String from = CurrencyEnum.EUR.getCode();
    @Min(0)
    @NotNull
    private BigDecimal amount = new BigDecimal(0.0);

    private String type = "current";

    private String date = "";

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CurrencyEnum getCurrencyEnumTo() {
        return Enum.valueOf(CurrencyEnum.class, to);
    }

    public CurrencyEnum getCurrencyEnumFrom() {
        return Enum.valueOf(CurrencyEnum.class, from);
    }

    public String getType() {
        return type;
    }

    public Boolean isHistory() {
        return type.equals("history");
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @AssertTrue
    public boolean isDataCorrect() {
        return type.equals("current") || !date.isEmpty();
    }
}
