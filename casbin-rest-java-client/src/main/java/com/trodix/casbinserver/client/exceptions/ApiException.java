package com.trodix.casbinserver.client.exceptions;

public class ApiException extends RuntimeException {

    public ApiException(Throwable t) {
        super(t);
    }

    public ApiException(String message) {
        super(message);
    }

}
