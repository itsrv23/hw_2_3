package ru.itsrv23.hw_calculator.servises;

public interface Calculator {
    String hello();
    String plus(String s1, String s2);
    String minus(String s1, String s2);
    String multiply(String s1, String s2);
    String divide(String s1, String s2);
    Boolean checkArgument(String s1, String s2);
    Boolean checkDivide(String s1);

}
