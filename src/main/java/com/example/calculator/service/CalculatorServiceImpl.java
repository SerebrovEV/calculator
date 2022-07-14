package com.example.calculator.service;


import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String serviceWelcome() {
        return "<b>Добро пожаловать в калькулятор!</b>";
    }
    @Override
    public int servicePlus(int number1, int number2) {
        int sum = number1 + number2;
        return sum;
    }
    @Override
    public int serviceMinus(int number1, int number2) {
        int residual = number1 - number2;
        return residual;
    }
    @Override
    public int serviceMultiply(int number1, int number2) {
        int multiply = number1 * number2;
        return multiply;
    }
    @Override
    public double serviceDivide(double number1, double number2) {
        double divide = number1 / number2;
        return divide;
    }
}
