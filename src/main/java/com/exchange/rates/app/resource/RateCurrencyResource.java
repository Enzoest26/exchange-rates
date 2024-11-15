package com.exchange.rates.app.resource;

import com.exchange.rates.app.service.RateCurrencyService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/rateCurrency")
public class RateCurrencyResource {

    RateCurrencyService rateCurrencyService;

    @Inject
    public RateCurrencyResource(RateCurrencyService rateCurrencyService) {
        this.rateCurrencyService = rateCurrencyService;
    }

    @GET
    @Path("/{codeCurrency}")
    public Response getRateCurrency(@PathParam("codeCurrency") String codeCurrency) {
        return Response.ok(rateCurrencyService.getRateCurrency(codeCurrency), MediaType.APPLICATION_JSON_TYPE).build();
    }
}
