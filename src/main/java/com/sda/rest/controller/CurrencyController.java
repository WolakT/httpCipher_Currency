package com.sda.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sda.rest.model.CurrencyRequest;
import com.sda.rest.model.CurrencyResponse;
import com.sda.rest.service.CurrencyService;

@Path("/currency")
public class CurrencyController {

    private CurrencyService currencyService;

    public CurrencyController() {
        currencyService = new CurrencyService();
    }

    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public CurrencyResponse createCar(CurrencyRequest currencyRequest) {
        return currencyService.calculate(currencyRequest);
    }

}
