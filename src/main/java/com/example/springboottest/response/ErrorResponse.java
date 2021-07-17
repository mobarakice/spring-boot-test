package com.example.springboottest.response;

import com.example.springboottest.util.ErrorStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponse extends ResponseEntity implements Response {

    public ErrorResponse(Error body, HttpStatus status) {
        super(body, status);
    }

    public static ErrorResponse getErrorResponse(ErrorStatus errorStatus, HttpStatus status) {
        return new ErrorResponse(Error.builder()
                .withCode(errorStatus.code())
                .withMessage(errorStatus.getMessage())
                .withStatus(status).build(), status);
    }
}
