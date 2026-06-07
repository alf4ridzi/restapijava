package com.lowcontext.restapijava.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSendResponse<T> {

    private final String status;
    private final T data;
    private final String message;
    private final Integer code;
    private final Instant timestamp;

    private JSendResponse(String status, T data, String message, Integer code) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.code = code;
        this.timestamp = Instant.now();
    }

    public static <T> JSendResponse<T> success(T data) {
        return new JSendResponse<>("success", data, null, null);
    }

    public static <T> JSendResponse<T> fail(T data) {
        return new JSendResponse<>("fail", data, null, null);
    }

    public static <T> JSendResponse<T> error(String message, Integer code) {
        return new JSendResponse<>("error", null, message, code);
    }

    public static <T> JSendResponse<T> error(String message) {
        return new JSendResponse<>("error", null, message, null);
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
