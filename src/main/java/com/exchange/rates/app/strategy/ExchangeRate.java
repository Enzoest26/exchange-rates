package com.exchange.rates.app.strategy;

import com.exchange.rates.app.client.ExchangeRateClient;
import com.exchange.rates.app.dto.ExchangeRateDto;
import com.exchange.rates.app.dto.exchange.ExchangeRateResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class ExchangeRate implements ExchangeRateStrategy {

    @Override
    public ExchangeRateDto getCurrentExchangeRate(String currency) {
        ExchangeRateClient client = getConfigurationClient();

        ExchangeRateResponse response = client.getRateCurrency(currency);

        return buildDto(currency, response);
    }

    private ExchangeRateClient getConfigurationClient() {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://open.er-api.com/v6/latest");

        ResteasyWebTarget rtarget = (ResteasyWebTarget)target;

        return rtarget.proxy(ExchangeRateClient.class);
    }

    private ExchangeRateDto buildDto(String currency, ExchangeRateResponse response) {
        return ExchangeRateDto.builder()
                .currency(currency)
                .rates(response.getRates())
                .build();
    }
}
