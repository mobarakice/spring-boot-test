package com.example.springboottest.response;

import org.springframework.http.HttpStatus;

public class Error {

    public static final String KEY_STATUS = "status";

    public static final String KEY_CODE = "code";

    public static final String KEY_MESSAGE = "message";

    private HttpStatus status;
    private Integer code;
    private String message;

    private Error(ErrorBuilder error) {
        this.code = error.code;
        this.message = error.message;
        this.status = error.status;
    }

    public static ICode builder() {
        return new ErrorBuilder();
    }

    public interface ICode {
        IMessage withCode(Integer code);
    }

    public interface IMessage {
        IStatus withMessage(String message);
    }

    public interface IStatus {
        IErrorBuild withStatus(HttpStatus status);
    }


    public interface IErrorBuild {
        Error build();
    }

    public static class ErrorBuilder implements IStatus, ICode, IMessage, IErrorBuild {

        private HttpStatus status;
        private Integer code;
        private String message;

        @Override
        public IMessage withCode(Integer code) {
            this.code = code;
            return this;
        }

        @Override
        public IStatus withMessage(String message) {
            this.message = message;
            return this;
        }

        @Override
        public IErrorBuild withStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        @Override
        public Error build() {
            return new Error(this);
        }
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
