package com.exchange.rates.app.client;

import com.exchange.rates.app.dto.ExchangeRateResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://open.er-api.com/v6/lastest")
public interface ExchangeRateClient {

    @GET
    @Path("/{codeCurrency}")
    ExchangeRateResponse getRateCurrency(@PathParam("codeCurrency") String codeCurrency);
}
