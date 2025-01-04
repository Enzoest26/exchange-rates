package com.exchange.rates.app.strategy;

import com.exchange.rates.app.client.FreeCurrencyClient;
import com.exchange.rates.app.dto.ExchangeRateDto;
import com.exchange.rates.app.dto.freecurrency.FreeCurrencyExchangeResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import java.util.Locale;
import java.util.Map;

public class FreeCurrency implements ExchangeRateStrategy {

    @Override
    public ExchangeRateDto getCurrentExchangeRate(String currency) {
        FreeCurrencyClient client = getConfigurationClient();
        currency = currency.toLowerCase(Locale.ROOT);
        Map<String, Object> response = client.currentExchangeRates(currency);

        return buildDto(currency, response);
    }

    private FreeCurrencyClient getConfigurationClient() {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1");

        ResteasyWebTarget rtarget = (ResteasyWebTarget)target;

        return rtarget.proxy(FreeCurrencyClient.class);
    }

    private ExchangeRateDto buildDto(String currency, Map<String, Object> response) {
        return ExchangeRateDto.builder()
                .currency(currency)
                .rates(response.get(currency))
                .build();
    }
}
