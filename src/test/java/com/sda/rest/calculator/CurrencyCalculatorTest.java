package com.sda.rest.calculator;

import com.sda.rest.model.Currency;
import com.sda.rest.model.CurrencyResponse;
import com.sda.rest.model.Rate;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RENT on 2017-07-28.
 */
public class CurrencyCalculatorTest {
    @Test
    public void shouldReturnCorrectMidVal(){
        Currency curr =  new Currency();
        curr.setCode("eur");
        List<Rate> rates = new ArrayList<>();
        Rate r1 = new Rate();
        r1.setEffectiveDate("2017-01-09");
        r1.setMid(new BigDecimal(3.4));
        Rate r2 = new Rate();
        r2.setEffectiveDate("2017-03-09");
        r2.setMid(new BigDecimal(4.6));

        rates.add(r1);
        rates.add(r2);
        curr.setRates(rates);
        CurrencyCalculator calculator = new CurrencyCalculator();
        CurrencyResponse response = calculator.calculate(curr);
        System.out.println(response.getMinRate());
    }

}