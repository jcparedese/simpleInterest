package com.aplazo.interest.simple.controller.payload;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

public class BaseEntityResponse<T> {

    private boolean success = true;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, Object> meta;


    public BaseEntityResponse() {
    }

    public BaseEntityResponse(T data) {
        this.data = data;
    }

    public static <T> BaseEntityResponse<T> createError(String error) {
        BaseEntityResponse<T> response = new BaseEntityResponse<>();
        response.setSuccess(false);
        response.setError(error);
        return response;
    }

    public static <T> BaseEntityResponse<T> createMessage(String message) {
        BaseEntityResponse<T> response = new BaseEntityResponse<>();
        response.setSuccess(true);
        response.setMessage(message);
        return response;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

    public BaseEntityResponse<T> addMeta(String key, Object value) {
        if (this.meta == null) {
            this.meta = new HashMap<>();
        }
        this.meta.put(key, value);
        return this;
    }

}
