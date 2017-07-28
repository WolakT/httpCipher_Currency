package com.sda.rest.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import com.sda.rest.model.Currency;
import com.sda.rest.model.CurrencyResponse;
import com.sda.rest.model.Rate;

public class CurrencyCalculator {

    public CurrencyResponse calculate(Currency currency) {

        RateWithDate min = findMin(currency);
        RateWithDate max = findMax(currency);
        BigDecimal avg = calculateAvg(currency);

        return new CurrencyResponse(max, min, avg);
    }

    private BigDecimal calculateAvg(Currency currency) {
        List<Rate> rates = currency.getRates();
        BigDecimal amount = new BigDecimal(rates.size());
        BigDecimal sum = new BigDecimal(0);
        for (Rate rate : rates) {
            sum = sum.add(rate.getMid());
        }
        return sum.divide(amount, new MathContext(3));
    }

    private RateWithDate findMin(Currency currency) {
        BigDecimal min = new BigDecimal(Integer.MAX_VALUE);

        List<Rate> rates = currency.getRates();
        String date = null;
        for (Rate rate : rates) {
            BigDecimal actual = rate.getMid();
            if (min.compareTo(actual) > 0) {
                min = actual;
                date = rate.getEffectiveDate();
            }
        }

        return new RateWithDate(min.setScale(2, BigDecimal.ROUND_HALF_UP),date);
    }

    private RateWithDate findMax(Currency currency) {
        BigDecimal max = BigDecimal.ZERO;
        List<Rate> rates = currency.getRates();
        String date = null;
        for (Rate rate : rates) {
            BigDecimal actual = rate.getMid();
            if (max.compareTo(actual) < 0) {
                max = actual;
            }
        }
        return new RateWithDate(max.setScale(2, BigDecimal.ROUND_HALF_UP),date);
    }

}
