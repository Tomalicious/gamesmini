package com.realdolmen.exceptions;

public class NotFoundException extends Throwable {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Exception e) {
        super(message, e);
    }
}
