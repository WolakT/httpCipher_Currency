package com.sda.rest.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sda.rest.calculator.RateWithDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyResponse {

    private RateWithDate maxRate;
    private RateWithDate minRate;
    private BigDecimal avgRate;
    private String errorMessage;

    public CurrencyResponse() {
    }

    public CurrencyResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CurrencyResponse(RateWithDate maxRate, RateWithDate minRate, BigDecimal avgRate) {
        this.maxRate = maxRate;
        this.minRate = minRate;
        this.avgRate = avgRate;
    }

    public RateWithDate getMaxRate() {
        return maxRate;
    }

    public RateWithDate getMinRate() {
        return minRate;
    }

    public BigDecimal getAvgRate() {
        return avgRate;
    }

    public void setMaxRate(RateWithDate maxRate) {
        this.maxRate = maxRate;
    }

    public void setMinRate(RateWithDate minRate) {
        this.minRate = minRate;
    }

    public void setAvgRate(BigDecimal avgRate) {
        this.avgRate = avgRate;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
