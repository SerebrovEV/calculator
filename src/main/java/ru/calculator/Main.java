package ru.calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static final Pattern patternRumNumber = Pattern.compile("[A-Z]");

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение для вычисления в формате: \n" +
                "1 + 2 или VI - V");
        String sentence = scanner.nextLine();
        while (!(sentence.equalsIgnoreCase("exit"))) {
            System.out.println(calc(sentence));
            System.out.println("Введите выражение для вычисления:");
            sentence = scanner.nextLine();
        }
    }

    private static String calc(String input) throws Exception {
        input = input.trim();
        String operation = validateOperation(input);
        String[] inputSentence = input.split("[+-/*]");
        int number1;
        int number2;
        if (checkRomNumber(inputSentence[0], inputSentence[1])) {
            number1 = romToArabNumber(inputSentence[0]);
            number2 = romToArabNumber(inputSentence[1]);
            return "Ответ = " + arabToRomNumber(calculation(number1, number2, operation));
        } else {
            number1 = Integer.parseInt(inputSentence[0]);
            number2 = Integer.parseInt(inputSentence[1]);
            validateNumber(number1, number2);
            return "Ответ = " + calculation(number1, number2, operation);
        }
    }

    private static int calculation(int number1, int number2, String operation) throws Exception {
        switch (operation) {
            case ("+") -> {
                return number1 + number2;
            }
            case ("-") -> {
                return number1 - number2;
            }
            case ("*") -> {
                return number1 * number2;
            }
            case ("/") -> {
                return number1 / number2;
            }
            default -> throw new Exception();
        }
    }

    private static boolean checkRomNumber(String number1, String number2) {
        Matcher matcherForNumber1 = patternRumNumber.matcher(number1);
        Matcher matcherForNumber2 = patternRumNumber.matcher(number2);
        return matcherForNumber1.find() && matcherForNumber2.find();
    }

    private static String arabToRomNumber(int number) throws Exception {
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
        if (number <= 0){
            throw new Exception();
        }
        return romanNumbers[number-1];
    }

    private static int romToArabNumber(String number) throws Exception {
        switch (number) {
            case ("I") -> {
                return 1;
            }
            case ("II") -> {
                return 2;
            }
            case ("III") -> {
                return 3;
            }
            case ("IV") -> {
                return 4;
            }
            case ("V") -> {
                return 5;
            }
            case ("VI") -> {
                return 6;
            }
            case ("VII") -> {
                return 7;
            }
            case ("VIII") -> {
                return 8;
            }
            case ("IX") -> {
                return 9;
            }
            case ("X") -> {
                return 10;
            }
            default -> throw new Exception();
        }
    }

    private static void validateNumber(int number1, int number2) throws Exception {
        if (number1 < 1 || number2 < 1 || number1 > 10 || number2 > 10) {
            throw new Exception();
        }
    }

    private static String validateOperation(String inputSentence) throws Exception {
        String operation = null;
        boolean findOperation = false;
        char[] sentenceChars = inputSentence.toCharArray();
        for (char sentenceChar : sentenceChars) {
            if (findOperation && ((sentenceChar == '+') || (sentenceChar == '-') || (sentenceChar == '*') || (sentenceChar == '/'))) {
                throw new Exception();
            }
            if (sentenceChar == '+') {
                operation = "+";
                findOperation = true;
                continue;
            }
            if (sentenceChar == '-') {
                operation = "-";
                findOperation = true;
                continue;
            }
            if (sentenceChar == '*') {
                operation = "*";
                findOperation = true;
                continue;
            }
            if (sentenceChar == '/') {
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