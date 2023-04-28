package ru.calculator;

public class RomNumberConverter {

    public static int romToArabNumber(String number) throws Exception {
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
            default -> throw new Exception("Некорректное римское число!");
        }
    }

    public static String arabToRomNumber(int number) throws Exception {
        StringBuilder answer = new StringBuilder();
        String[] romanNumbers = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
        if (number < 1) {
            throw new Exception("Римские числа не могут быть меньше 1!");
        }
        while (number > 0) {
            if (number / 100 >= 1) {
                answer.append(romanNumbers[8]);
                number = number % 100;
                continue;
            }
            if (number / 90 >= 1) {
                answer.append(romanNumbers[7]);
                number = number - 90;
                continue;
            }
            if (number / 50 >= 1) {
                answer.append(romanNumbers[6]);
                number = number - 50;
                continue;
            }
            if (number / 40 >= 1) {
                answer.append(romanNumbers[5]);
                number = number - 40;
                continue;
            }
            if (number / 10 >= 1) {
                answer.append(romanNumbers[4]);
                number = number - 10;
                continue;
            }
            if (number == 9) {
                answer.append(romanNumbers[3]);
                break;
            }
            if (number / 5 >= 1) {
                answer.append(romanNumbers[2]);
                number = number - 5;
                continue;
            }
            if (number == 4) {
                answer.append(romanNumbers[1]);
                break;
            }
            if (number < 4) {
                answer.append(romanNumbers[0]);
                number = number - 1;
            }
        }
        return String.valueOf(answer);
    }
}
