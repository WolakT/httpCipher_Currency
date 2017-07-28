package com.sda.rest.controller;

import com.sda.rest.model.CurrencyRequest;
import com.sda.rest.model.CurrencyResponse;
import com.sda.rest.service.CurrencyService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by RENT on 2017-07-28.
 */
@Path("/encrypt")
public class CipherController {

        private CurrencyService currencyService;

        public CipherController() {
            currencyService = new CurrencyService();
        }

        @POST
        @Produces("application/json")
        @Consumes(MediaType.APPLICATION_JSON)
        public CurrencyResponse createCar(CurrencyRequest currencyRequest) {
            return currencyService.calculate(currencyRequest);
        }

    }
