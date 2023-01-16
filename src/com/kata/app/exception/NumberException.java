package com.kata.app.exception;

public class NumberException extends RuntimeException{
    private final String number;

    public NumberException(String number) {
        this.number = number;
    }

    public NumberException(String message, String number) {
        super(message);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
