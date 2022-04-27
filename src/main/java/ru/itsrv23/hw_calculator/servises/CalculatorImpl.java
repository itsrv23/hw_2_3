package ru.itsrv23.hw_calculator.servises;

import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements Calculator {
    private final String badParams = "Вы ввели не правильный параметр. Введите целочисленное значение";

    @Override
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public String plus(String s1, String s2) {
        if (!checkArgument(s1, s2)) {
            return badParams;
        } else {
            return String.valueOf(Integer.parseInt(s1) + Integer.parseInt(s2));
        }

    }

    @Override
    public String minus(String s1, String s2) {
        if (!checkArgument(s1, s2)) {
            return badParams;
        } else {
            return String.valueOf(Integer.parseInt(s1) - Integer.parseInt(s2));
        }
    }

    @Override
    public String multiply(String s1, String s2) {
        if (!checkArgument(s1, s2)) {
            return badParams;
        } else {
            return String.valueOf(Integer.parseInt(s1) * Integer.parseInt(s2));
        }
    }

    @Override
    public String divide(String s1, String s2) {
        if (!checkArgument(s1, s2)) {
            return badParams;
        }

        if (checkDivide(s2)) {
            System.out.println("Деление на 0 запрещено");
            return "Деление на 0 запрещено";
        } else {
            return String.valueOf(Integer.parseInt(s1) / Integer.parseInt(s2));
        }
    }

    @Override
    public Boolean checkArgument(String s1, String s2) {
        try {
            Integer.parseInt(s1);
            Integer.parseInt(s2);
            return true;
        } catch (Exception e) {
            System.out.println("IllegalArgumentException");
        }
        return false;
    }

    @Override
    public Boolean checkDivide(String s1) {
        return s1.equals("0");
    }


}
