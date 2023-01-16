package com.kata.app.exception;

public class IncorrectInputException extends NumberException {
    public IncorrectInputException(String number) {
        super("Используются одновременно разные системы счисления " + number, number);
    }
}
