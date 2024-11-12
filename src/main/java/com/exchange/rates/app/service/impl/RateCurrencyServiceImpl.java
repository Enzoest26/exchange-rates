package com.exchange.rates.app.service.impl;

import com.exchange.rates.app.client.ExchangeRateClient;
import com.exchange.rates.app.dto.ExchangeRateResponse;
import com.exchange.rates.app.service.RateCurrencyService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class RateCurrencyServiceImpl implements RateCurrencyService {

    @Inject
    @RestClient
    ExchangeRateClient exchangeRateClient;

    @Override
    public ExchangeRateResponse getRateCurrency(String codeCurrency) {
        return this.exchangeRateClient.getRateCurrency(codeCurrency);
    }
}
