package calculator.calculator;

import java.util.Scanner;

public class Calculator {

    public static int a, b;
    public static int result;

    public static void main(String[] args) {

        System.out.println("");
        System.out.println("Введи 2 римских или арабских числа от 1 до 10 включительно и знак" +
                " арифметической операции. Элементы разделяются пробелами.");
        System.out.println("Примеры");
        System.out.println("1 + 2" + "  или  " + "I + V");
        System.out.println("ВВЕДИ ЧИСЛА И ОПЕРАТОР");

        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        String[] strParts = str.split(" ");

        try {
            if (strParts.length != 3) {
                throw new Exception("Формат операции не удовлятверет условиям задания.");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }

        if ((ValidationCheck.isValidity(strParts)) &&
                (RomanList.isCorrectRomanList(strParts[0])) &&
                (OperatorsList.isOperator(strParts[1]))) {
            a = RomanList.romanToArabian(strParts[0]);
            b = RomanList.romanToArabian(strParts[2]);
            switch (strParts[1]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
            }
            try {
                if (result <= 0) {
                    throw new Exception("В римской системе нет отрицательных чисел.");
                } else {
                    String resultRoman = RomanList.arabianToRoman(result);
                    System.out.println(resultRoman);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } else if ((ValidationCheck.isValidity(strParts)) &&
                (Integer.parseInt(strParts[0]) >= 1 && Integer.parseInt(strParts[0]) <= 10) &&
                (OperatorsList.isOperator(strParts[1]))) {
            a = Integer.parseInt(strParts[0]);
            b = Integer.parseInt(strParts[2]);
            switch (strParts[1]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
            }
            System.out.println(result);
        }
    }
}