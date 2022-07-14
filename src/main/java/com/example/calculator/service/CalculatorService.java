package com.example.calculator.service;


public interface CalculatorService {
    String serviceWelcome();

    int servicePlus(int number1, int number2);

    int serviceMinus(int number1, int number2);

    int serviceMultiply(int number1, int number2);

    double serviceDivide(double number1, double number2);
}
