package com.exchange.rates.app.client;

import com.exchange.rates.app.dto.freecurrency.FreeCurrencyAvailableCurrencyResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

public interface FreeCurrencyClient {

    @GET
    @Path("lastest/v1/currency.json")
    FreeCurrencyAvailableCurrencyResponse availableCurrency();
}
