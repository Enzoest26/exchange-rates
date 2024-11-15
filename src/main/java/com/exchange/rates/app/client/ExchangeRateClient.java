package com.exchange.rates.app.client;

import com.exchange.rates.app.dto.ExchangeRateResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;


public interface ExchangeRateClient {

    @GET
    @Path("/{codeCurrency}")
    @Consumes({MediaType.APPLICATION_JSON})
    ExchangeRateResponse getRateCurrency(@PathParam("codeCurrency") String codeCurrency);
}
