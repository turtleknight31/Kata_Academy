package com.kata.app.calc;


import java.util.Arrays;

public class Roman {

    public static int romanToInt(String s) {
        char[] strToArray = s.toCharArray();

        int index = 0;
        int num = 0;

        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] number = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for(int i = 0; i < strToArray.length; i++) {
            if (String.valueOf(strToArray[i]).equals("I") && i+1 < strToArray.length && String.valueOf(strToArray[i+1]).equals("V") || String.valueOf(strToArray[i]).equals("I") && i+1 < strToArray.length && String.valueOf(strToArray[i+1]).equals("X")) {
                index = Arrays.asList(str).indexOf(String.valueOf(strToArray[i]) + String.valueOf(strToArray[i+1]));
                num = num + number[index];
                i++;
            } else if (String.valueOf(strToArray[i]).equals("X") && i+1 < strToArray.length  &&  String.valueOf(strToArray[i+1]).equals("L") || String.valueOf(strToArray[i]).equals("X") && i+1 < strToArray.length && String.valueOf(strToArray[i+1]).equals("C")) {
                index = Arrays.asList(str).indexOf(String.valueOf(strToArray[i]) + String.valueOf(strToArray[i+1]));
                num = num + number[index];
                i++;
            } else if (String.valueOf(strToArray[i]).equals("C") && i+1 < strToArray.length && String.valueOf(strToArray[i+1]).equals("D") || String.valueOf(strToArray[i]).equals("C") && String.valueOf(strToArray[i+1]).equals("M")) {
                index = Arrays.asList(str).indexOf(String.valueOf(strToArray[i]) + String.valueOf(strToArray[i+1]));
                num = num + number[index];
                i++;
            } else  {
                index = Arrays.asList(str).indexOf(String.valueOf(strToArray[i]));
                num = num + number[index];
            }
        }
        return num;
    }
}
