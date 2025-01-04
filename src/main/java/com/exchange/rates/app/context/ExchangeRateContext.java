package com.exchange.rates.app.context;

import com.exchange.rates.app.dto.ExchangeRateDto;
import com.exchange.rates.app.strategy.ExchangeRateStrategy;
import lombok.Setter;

@Setter
public class ExchangeRateContext {

    private ExchangeRateStrategy exchangeRateStrategy;

    public ExchangeRateContext(ExchangeRateStrategy exchangeRateStrategy) {
        this.exchangeRateStrategy = exchangeRateStrategy;
    }

    public ExchangeRateDto getCurrentExchangeRate(String currency) {
        return this.exchangeRateStrategy.getCurrentExchangeRate(currency);
    }
}
