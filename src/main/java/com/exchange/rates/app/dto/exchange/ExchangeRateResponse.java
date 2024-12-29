package com.exchange.rates.app.dto.exchange;

import lombok.Data;

@Data
public class ExchangeRateResponse {

    private String result;

    private String base_code;

    private Rates rates;
}
