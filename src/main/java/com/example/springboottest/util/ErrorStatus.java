package com.example.springboottest.util;

public enum ErrorStatus {
    // Common Error
    UNKNOWN_ERROR(1000, "Unknown Error"),
    CUSTOMER_CREATED(1001, "Customer creation failed"),
    UPDATE_FAILED(1002, "Update failed"),
    USER_NAME_REQUIRED(1003, "Customer name required"),
    USER_EMIL_REQUIRED(1003, "Customer email required"),
    USER_PHONE_REQUIRED(1003, "Customer phone required"),
    CUSTOMER_NOT_FOUND(1015, "Customer not found");

    private final int code;
    private final String message;

    private ErrorStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
