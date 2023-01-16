package com.kata.app;

public enum RomanNumber {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10),
    XX(20),
    XXX(30),
    XL(40),
    L(50),
    LX(60),
    LXX(70),
    LXXX(80),
    XC(90),
    C(100),
    NotExist(101),
    ;
    private int code;

    RomanNumber(int code) {
        this.code = code;
    }

    public static RomanNumber of(int code) {
        for (RomanNumber type : RomanNumber.values()) {
            if (type.code == code) {
                return type;
            }
        }
        return NotExist;
    }

    public static String getName(String name) {
        for (RomanNumber type : RomanNumber.values()) {
            if (type.toString().equalsIgnoreCase(name)) {
                return type.toString();
            }
        }
        return NotExist.toString();
    }

    public String getCode() {
        return String.valueOf(code);
    }
}
