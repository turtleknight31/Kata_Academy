package com.kata.app.calc;

public class Calculator {
    private  String mathExpression;

    public Calculator(String mathExpression) {
        this.mathExpression = mathExpression;
    }

    public int calculate() {
        String[] words = mathExpression.split(" ");
        int num1 = Integer.parseInt(words[0]);
        int num2 = Integer.parseInt(words[2]);

        return switch (words[1]) {
            case "+" -> Math.addExact(num1, num2);
            case "-" -> Math.subtractExact(num1, num2);
            case "*" -> Math.multiplyExact(num1, num2);
            case "/" -> num1 / num2;
            default -> 0;
        };
    }
}