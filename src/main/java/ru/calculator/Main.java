package ru.calculator;

import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String sentence = "start";
        while (!(sentence.equalsIgnoreCase("exit"))) {
            sentence = scanner.nextLine();
            System.out.println(calc(sentence));
        }
    }

    public static String calc(String input) throws Exception {
        boolean isCorrect = false;
        if (input.contains("+")) {
            System.out.println("plus");
            isCorrect = true;
        }
        if (input.contains("-")) {
            System.out.println("minus");
            if (isCorrect) {
                throw new Exception();
            } else {
                isCorrect = true;
            }
        }
        if (input.contains("*")) {
            System.out.println("multiplication");
            if (isCorrect) {
                throw new Exception();
            } else {
                isCorrect = true;
            }
        }
        if (input.contains("/")) {
            System.out.println("divide");
            if (isCorrect) {
                throw new Exception();
            }
        }
        return input;
    }

}