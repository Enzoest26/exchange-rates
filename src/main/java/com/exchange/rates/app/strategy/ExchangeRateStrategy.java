package com.exchange.rates.app.strategy;

import com.exchange.rates.app.dto.ExchangeRateDto;

public interface ExchangeRateStrategy {

    ExchangeRateDto getCurrentExchangeRate(String currency);
}
