package com.exchange.rates.app.resource;

import com.exchange.rates.app.dto.ApiResponse;
import com.exchange.rates.app.service.RateCurrencyService;
import com.exchange.rates.app.util.CurrencyApi;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/rateCurrency")
public class RateCurrencyResource {

    private final RateCurrencyService rateCurrencyService;

    @Inject
    public RateCurrencyResource(RateCurrencyService rateCurrencyService) {
        this.rateCurrencyService = rateCurrencyService;
    }

    @GET
    @Path("/{currentApi}/{codeCurrency}")
    public Response getRateCurrency(@PathParam("currentApi") CurrencyApi currencyApi, @PathParam("codeCurrency") String codeCurrency) {
        return Response.ok(ApiResponse.ok(rateCurrencyService.getRateCurrency(codeCurrency, currencyApi), "List of current rate currency"), MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
