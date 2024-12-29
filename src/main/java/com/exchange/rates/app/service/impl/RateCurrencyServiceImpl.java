package com.exchange.rates.app.service.impl;

import com.exchange.rates.app.client.ExchangeRateClient;
import com.exchange.rates.app.dto.exchange.ExchangeRateResponse;
import com.exchange.rates.app.service.RateCurrencyService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@ApplicationScoped
public class RateCurrencyServiceImpl implements RateCurrencyService {

    @Override
    public ExchangeRateResponse getRateCurrency(String codeCurrency) {
        ExchangeRateClient client = getConfigurationClient();

        return client.getRateCurrency(codeCurrency);
    }

    // ADD TO CONFIG FILE
    private ExchangeRateClient getConfigurationClient() {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://open.er-api.com/v6/latest");

        ResteasyWebTarget rtarget = (ResteasyWebTarget)target;

        return rtarget.proxy(ExchangeRateClient.class);
    }
}
