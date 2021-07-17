package com.example.springboottest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse<T> implements Response {

    private HttpStatus status;

    public SuccessResponse() {

    }

    public HttpStatus getStatus() {
        return status;
    }

    public T setStatus(HttpStatus status) {
        this.status = status;
        return (T) this;
    }
}
