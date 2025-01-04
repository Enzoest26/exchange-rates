package com.exchange.rates.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExchangeRateDto {

    private String currency;

    private Object rates;
}
