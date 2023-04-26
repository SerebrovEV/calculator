package ru.calculator;

import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение для вычисления в формате: \n" +
                "1+2 или VI-V");
        String sentence = scanner.nextLine();
        while (!(sentence.equalsIgnoreCase("exit"))) {
            System.out.println(calc(sentence));
            System.out.println("Введите выражение для вычисления:");
            sentence = scanner.nextLine();
        }
    }

    public static String calc(String input) throws Exception {
        input = input.trim();
        String operation = validateOperation(input);
        String[] inputSentence = input.split("\\" + operation);
        int number1 = Integer.parseInt(inputSentence[0]);
        int number2 = Integer.parseInt(inputSentence[1]);
        validateNumber(number1, number2);
        return "Ответ = " + calculation(number1, number2, operation);

    }

    private static int calculation(int number1, int number2, String operation) throws Exception {
        switch (operation) {
            case ("+") -> {
                return number1 + number2;
            }
            case("-") -> {
                return number1 - number2;
            }
            case("*") -> {
                return number1 * number2;
            }
            case("/") -> {
                return number1 / number2;
            }
            default -> throw new Exception();
        }
    }

    private static void validateNumber(int number1, int number2) throws Exception {
        if (number1 < 0 || number2 < 0 || number1 > 10 || number2 > 10) {
            throw new Exception();
        }
    }

    private static String validateOperation(String sentence) throws Exception {
        String operation = null;
        boolean findOperation = false;
        char[] sentenceChar = sentence.toCharArray();
        for (char c : sentenceChar) {
            if (findOperation && ((c == '+') || (c == '-') || (c == '*') || (c == '/'))) {
                throw new Exception();
            }
            if (c == '+') {
                operation = "+";
                findOperation = true;
                continue;
            }
            if (c == '-') {
                operation = "-";
                findOperation = true;
                continue;
            }
            if (c == '*') {
                operation = "*";
                findOperation = true;
                continue;
            }
            if (c == '/') {
                operation = "/";
                findOperation = true;
            }
        }
        if (operation != null) {
            return operation;
        } else {
            throw new Exception();
        }
    }

}