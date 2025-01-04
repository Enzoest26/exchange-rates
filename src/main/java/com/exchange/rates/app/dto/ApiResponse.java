package com.exchange.rates.app.dto;

import lombok.Builder;
import lombok.Data;
import org.apache.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiResponse {

    private LocalDateTime time;

    private String status;

    private String message;

    private Object data;

    public static ApiResponse ok(Object data, String message) {
        return ApiResponse.builder()
                .data(data)
                .message(message)
                .status(String.valueOf(HttpStatus.SC_OK))
                .time(LocalDateTime.now())
                .build();
    }

    public static ApiResponse create(Object data, String message) {
        return ApiResponse.builder()
                .data(data)
                .message(message)
                .status(String.valueOf(HttpStatus.SC_CREATED))
                .time(LocalDateTime.now())
                .build();
    }

    public static ApiResponse internalError(Object data, String message) {
        return ApiResponse.builder()
                .data(data)
                .message(message)
                .status(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR))
                .time(LocalDateTime.now())
                .build();
    }
}
