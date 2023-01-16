package com.kata.app.exception;

public class IncorrectMathOperationException extends NumberException {
    public IncorrectMathOperationException(String number) {
        super("Cтрока не является математической операцией " + number, number);
    }
}
