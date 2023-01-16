package com.kata.app.exception;

public class NotExistNumberException extends NumberException {
    public NotExistNumberException(String number) {
        super("Number " + number + " not exist", number);
    }
}
