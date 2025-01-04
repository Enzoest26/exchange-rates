package com.exchange.rates.app.service;

import com.exchange.rates.app.context.ExchangeRateContext;
import com.exchange.rates.app.dto.ExchangeRateDto;
import com.exchange.rates.app.dto.exchange.ExchangeRateResponse;
import com.exchange.rates.app.strategy.ExchangeRate;
import com.exchange.rates.app.strategy.FreeCurrency;
import com.exchange.rates.app.util.CurrencyApi;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Objects;

@ApplicationScoped
public class RateCurrencyService {

    public ExchangeRateDto getRateCurrency(String codeCurrency, CurrencyApi currencyApi) {
        ExchangeRateContext context = switch (currencyApi) {
            case FREE_CURRENCY -> new ExchangeRateContext(new FreeCurrency());
            case EXCHANGE_RATE -> new ExchangeRateContext(new ExchangeRate());
        };

        return context.getCurrentExchangeRate(codeCurrency);
    }
}
