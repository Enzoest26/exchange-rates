package com.exchange.rates.app.client;

import com.exchange.rates.app.dto.freecurrency.FreeCurrencyAvailableCurrencyResponse;
import com.exchange.rates.app.dto.freecurrency.FreeCurrencyExchangeResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

import java.util.Map;

public interface FreeCurrencyClient {

    @GET
    @Path("/currency.json")
    FreeCurrencyAvailableCurrencyResponse availableCurrency();

    @GET
    @Path("/currencies/{currency}.json")
    @Consumes({MediaType.APPLICATION_JSON})
    Map<String, Object> currentExchangeRates(@PathParam("currency") String currency);
}
