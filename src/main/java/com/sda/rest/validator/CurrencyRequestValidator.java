package com.sda.rest.validator;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import com.sda.rest.model.CurrencyRequest;
import com.sda.rest.model.CurrencyResponse;

public class CurrencyRequestValidator {

    public CurrencyResponse createIfNotValid(CurrencyRequest currencyRequest) {
        if (isEmpty(currencyRequest.getCurrency())) {
            return new CurrencyResponse("currency can not be empty");
        }
        //TODO: dodac walicacje dla from i to

        return null;
    }
}
