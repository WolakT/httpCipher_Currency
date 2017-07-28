package com.sda.rest.validator;

import com.sda.rest.model.CurrencyResponse;
import org.junit.Before;
import org.junit.Test;

import com.sda.rest.model.CurrencyRequest;

import static org.junit.Assert.assertEquals;

public class CurrencyRequestValidatorTest {

    private CurrencyRequestValidator currencyRequestValidator;

    @Before
    public void setUp() {
        currencyRequestValidator = new CurrencyRequestValidator();
    }

    @Test
    public void shouldReturnNotValidWhenCurrencyDoesNotExist() {
        CurrencyRequest currencyRequest = new CurrencyRequest();
        currencyRequest.setFrom("2017-01-01");
        currencyRequest.setTo("2017-07-01");

        CurrencyResponse notValid = currencyRequestValidator.createIfNotValid(currencyRequest);
        assertEquals("currency can not be empty",notValid.getErrorMessage());
    }


    //TODO: dodac pozostałe testy


}