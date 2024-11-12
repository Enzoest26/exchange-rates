package com.exchange.rates.app.service;

import com.exchange.rates.app.dto.ExchangeRateResponse;

public interface RateCurrencyService {

    ExchangeRateResponse getRateCurrency(String codeCurrency);
}
