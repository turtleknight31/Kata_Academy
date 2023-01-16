package com.kata.app.exception;

public class IncorrectOperandException extends NumberException {
    public IncorrectOperandException(String number) {
        super("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *) " + number, number);
    }
}
