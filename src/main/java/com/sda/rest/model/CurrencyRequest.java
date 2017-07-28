package com.sda.rest.model;

public class CurrencyRequest {

    private String currency;
    private String from;
    private String to;

    public CurrencyRequest() {
    }

    public String getCurrency() {
        return currency;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
