package com.example.orderkiosk.controller;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Response<T> {
    private final HttpStatus status;
    private final String message;
    private final T data;

    public Response(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(HttpStatus.OK, "SUCCESS", data);
    }

    public static <T> Response<T> fail(String errorMessage) {
        return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage, null);
    }
}
