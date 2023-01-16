package com.kata.app.exception;

public class NegativeNumberException extends NumberException {
    public NegativeNumberException(int number) {
        super("В римской системе нет отрицательных чисел " + number, String.valueOf(number));
    }
}
