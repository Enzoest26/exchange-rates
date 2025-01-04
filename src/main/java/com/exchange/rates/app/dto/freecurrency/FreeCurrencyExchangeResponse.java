package com.exchange.rates.app.dto.freecurrency;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Data
public class FreeCurrencyExchangeResponse {

    private LocalDate date;

    private Map<String, Object> field;
}
