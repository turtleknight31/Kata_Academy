package com.kata.app;

import com.kata.app.exception.*;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

    static Scanner scan = new Scanner(System.in);

    public static void main (String[] args) {
        String expression = " ";
        char ch;
        int returnNumber;
        String returnRomanNumber;
        do {
            System.out.print("Введите выражение через пробел: ");

            expression = scan.nextLine();
            checkExpression(expression);
            ch = expression.charAt(0);

            if(!(ch >= '0' && ch <= '9')) {
                expression = changeRomanNumberToNumber(expression);
            }

            com.kata.app.calc.Calculator calculator = new com.kata.app.calc.Calculator(expression);
            returnNumber = calculator.calculate();

            if(ch >= '0' && ch <= '9') {
                System.out.println("Результат:  " + returnNumber);
            } else {
                returnRomanNumber = returnRomanNumber(returnNumber);
                System.out.println("Результат:  " + returnRomanNumber);
            }
        } while(isNext());
        System.out.println("Вы завершили вычисления!");
    }

    //Метод, чтобы понять, продолжать вычисления или нет
    public static boolean isNext() {
        String choice;
        do {
            System.out.print("Вы хотите продолжить? [yes/no]: ");
            choice = scan.nextLine();
            if((!choice.equals("no")) && (!choice.equals("yes"))) {
                System.out.println("Повторите пожалуйста ввод: ");
            }
        } while(!choice.equals("no") && !choice.equals("yes"));
        return choice.equals("yes");
    }

    //Преобразовываем римские числа в арабские, чтобы посчитать
    public static String changeRomanNumberToNumber(String str) {
        String [] Str = new String[3];
        int i = 0;
        for (String retval : str.split(" ")) {
            Str[i] = retval;
            i++;
        }
        char ch1 = Str[0].charAt(0);
        char ch2 = Str[2].charAt(0);

        if(ch1 >= '0' && ch1 <= '9' || ch2 >= '0' && ch2 <= '9') {
            throw new IncorrectInputException(Str[0]);
        }
        return RomanNumber.valueOf(Str[0]).getCode() + " " + Str[1] + " " + RomanNumber.valueOf(Str[2]).getCode();
    }

    //метод которые заменяет арабские числа на римские
    public static String returnRomanNumber(int number) {
        String romanNumber;
        int lNumber = number % 10;
        number = number - lNumber;

        if (lNumber == 0 && number > 0) {
            romanNumber = RomanNumber.of(number).name();
        } else if(number > 0 && lNumber > 0) {
            romanNumber = RomanNumber.of(number).name() + RomanNumber.of(lNumber).name();
        } else if(number < 0 || lNumber < 0) {
            throw new NegativeNumberException(number);
        } else if (number == 0 && lNumber > 0) {
            romanNumber = RomanNumber.of(lNumber).name();
        } else {
            romanNumber = "0";
        }
        return romanNumber;
    }

    //Проверка выражения, и делаем все проверки которые нужны, если не совпадает то выбрасываем исключение
    public static void checkExpression(String expression) {
        String[] Str = new String[3];
        int i = 0;

        for (String retval : expression.split(" ")) {
            if(i == 3) {
                throw new IncorrectOperandException(Str[0]);
            }
            Str[i] = retval;
            i++;
        }

        if(i < 2) {
            throw new IncorrectMathOperationException(Str[0]);
        }

        char ch1 = Str[0].charAt(0);
        char ch2 = Str[2].charAt(0);

        boolean result0 = Pattern.matches("^[*+-/]$", Str[1]);
        if(!result0) {
            throw new IncorrectOperandException(Str[0]);
        }

        if(!(ch2 >= '0' && ch2 <= '9') && (RomanNumber.getName(Str[0]).equalsIgnoreCase("NotExist") || RomanNumber.getName(Str[2]).equalsIgnoreCase("NotExist"))) {
            throw new NotExistNumberException(Str[0]);
        }

        if((ch1 >= '0' && ch1 <= '9' && !(ch2 >= '0' && ch2 <= '9')) || (!(ch1 >= '0' && ch1 <= '9') && ch2 >= '0' && ch2 <= '9')) {
            throw new IncorrectInputException(Str[0]);
        }
    }
}
