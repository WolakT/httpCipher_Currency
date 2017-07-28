package com.sda.rest.calculator;

import java.math.BigDecimal;

/**
 * Created by RENT on 2017-07-28.
 */
public class RateWithDate {
    private BigDecimal midRate;
    private String date;


    public RateWithDate(BigDecimal midRate, String date) {
        this.midRate = midRate;
        this.date = date;
    }

    public BigDecimal getMidRate() {
        return midRate;
    }

    public void setMidRate(BigDecimal midRate) {
        this.midRate = midRate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "midRate=" + midRate +
                ", date=" + date ;
    }


}
