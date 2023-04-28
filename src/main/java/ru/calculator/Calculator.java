package ru.calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    static final Scanner scanner = new Scanner(System.in);
    static final Pattern patternRomNumber = Pattern.compile("[A-Z]");
    static final Pattern patternArabNumber = Pattern.compile("[1-9]");

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
        input = input.replaceAll(" ", "");
        String operation = validateOperation(input);
        String[] inputSentence = input.split("[+-/*]");
        String number1 = inputSentence[0];
        String number2 = inputSentence[1];
        if (checkRomNumber(number1, number2)) {
            int romNumber1 = RomNumberConverter.romToArabNumber(number1);
            int romNumber2 = RomNumberConverter.romToArabNumber(number2);
            return "Ответ = " + RomNumberConverter.arabToRomNumber(calculation(romNumber1, romNumber2, operation));
        } else if (checkArabNumber(number1, number2)) {
            int arabNumber1 = Integer.parseInt(number1);
            int arabNumber2 = Integer.parseInt(number2);
            return "Ответ = " + calculation(arabNumber1, arabNumber2, operation);
        } else {
            throw new Exception("Некорректное арифметическое выражение!");
        }
    }

    private static int calculation(int number1, int number2, String operation) throws Exception {
        validateNumber(number1, number2);
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
        Matcher matcherForNumber1 = patternRomNumber.matcher(number1);
        Matcher matcherForNumber2 = patternRomNumber.matcher(number2);
        return matcherForNumber1.find() && matcherForNumber2.find();
    }

    private static boolean checkArabNumber(String number1, String number2) {
        Matcher matcherForNumber1 = patternArabNumber.matcher(number1);
        Matcher matcherForNumber2 = patternArabNumber.matcher(number2);
        return matcherForNumber1.find() && matcherForNumber2.find();
    }
    private static void validateNumber(int number1, int number2) throws Exception {
        if (number1 < 1 || number2 < 1 || number1 > 10 || number2 > 10) {
            throw new Exception("Некорректный диапазон чисел!");
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
            throw new Exception("Некорректная арифметическая операция!");
        }
    }

}