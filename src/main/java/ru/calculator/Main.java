package ru.calculator;

import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String sentence = "start";
        while (!(sentence.equalsIgnoreCase("exit"))) {
            sentence = scanner.nextLine();
            System.out.println(calc(sentence));
        }
    }

    public static String calc(String input) {
        if (input.contains("+")) {
            System.out.println("plus");
        } else if (input.contains("-")) {
            System.out.println("minus");
        } else if (input.contains("*")) {
            System.out.println("multiplication");
        } else if (input.contains("/")) {
            System.out.println("divide");
        }
        return input;
    }

}