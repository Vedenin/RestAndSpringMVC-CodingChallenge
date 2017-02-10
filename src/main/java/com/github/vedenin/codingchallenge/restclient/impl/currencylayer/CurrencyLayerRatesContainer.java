package com.github.vedenin.codingchallenge.restclient.impl.currencylayer;

import java.util.Map;

/**
 * Created by slava on 04.02.17.
 */
public class CurrencyLayerRatesContainer {
    private Boolean success;
    private String terms;
    private String privacy;
    private Boolean historical;
    private String date;
    private String source;
    private Long timestamp;
    private ErrorContainer error;
    private Map<String, String> quotes;

    public ErrorContainer getError() {
        return error;
    }

    public void setError(ErrorContainer error) {
        this.error = error;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public Boolean getHistorical() {
        return historical;
    }

    public void setHistorical(Boolean historical) {
        this.historical = historical;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Map<String, String> getQuotes() {
        return quotes;
    }

    public void setQuotes(Map<String, String> quotes) {
        this.quotes = quotes;
    }

    @Override
    public String toString() {
        return "CurrencyLayerRatesContainer{" +
                "success=" + success +
                ", terms='" + terms + '\'' +
                ", privacy='" + privacy + '\'' +
                ", historical=" + historical +
                ", date='" + date + '\'' +
                ", source='" + source + '\'' +
                ", timestamp=" + timestamp +
                ", quotes=" + quotes +
                '}';
    }

    public static class ErrorContainer {
        public String code;
        public String info;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        @Override
        public String toString() {
            return "ErrorContainer{" +
                    "code='" + code + '\'' +
                    ", info='" + info + '\'' +
                    '}';
        }
    }
}
