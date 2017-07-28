package com.sda.rest.service;

import java.io.IOException;
import java.util.Objects;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.rest.calculator.CurrencyCalculator;
import com.sda.rest.model.Currency;
import com.sda.rest.model.CurrencyRequest;
import com.sda.rest.model.CurrencyResponse;
import com.sda.rest.validator.CurrencyRequestValidator;

public class CurrencyService {

    private static final String NPB_URL_PATTERN = "http://api.nbp.pl/api/exchangerates/rates/a/%s/%s/%s";
    private HttpClient httpClient;
    private ObjectMapper objectMapper;
    private CurrencyCalculator currencyCalculator;
    private CurrencyRequestValidator currencyRequestValidator;

    public CurrencyService() {
        httpClient = HttpClientBuilder.create()
                .build();
        objectMapper = new ObjectMapper();
        currencyCalculator = new CurrencyCalculator();
        currencyRequestValidator = new CurrencyRequestValidator();
    }

    public CurrencyResponse calculate(CurrencyRequest currencyRequest) {
        CurrencyResponse notValid = currencyRequestValidator.createIfNotValid(currencyRequest);
        if (Objects.nonNull(notValid)) {
            return notValid;
        }
        Currency currency = callCurrencyService(currencyRequest);
        return currencyCalculator.calculate(currency);
    }

    private Currency callCurrencyService(CurrencyRequest currencyRequest) {

        String url = String.format(NPB_URL_PATTERN, currencyRequest.getCurrency(), currencyRequest.getFrom(),
                currencyRequest.getTo());

        HttpResponse httpResponse = null;
        String content;
        HttpGet httpRequest = new HttpGet(url);
        try {
            httpResponse = httpClient.execute(httpRequest);
            content = IOUtils.toString(httpResponse.getEntity()
                    .getContent(), "UTF-8");
            return objectMapper.readValue(content, Currency.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
