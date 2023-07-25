package Calci;

import java.util.Scanner;

public class Calculator {
    private static double result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Current Result: " + result);
            System.out.println("Enter an operation (+, -, *, /) or 'q' to quit: ");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("q")) {
                running = false;
                continue;
            }

            System.out.println("Enter a number: ");
            double number = Double.parseDouble(scanner.nextLine());

            switch (operation) {
                case "+":
                    add(number);
                    break;
                case "-":
                    subtract(number);
                    break;
                case "*":
                    multiply(number);
                    break;
                case "/":
                    divide(number);
                    break;
                default:
                    System.out.println("Invalid operation.");
            }
        }

        System.out.println("Calculator has been closed.");
    }

    public static void add(double number) {
        result += number;
    }

    public static void subtract(double number) {
        result -= number;
    }

    public static void multiply(double number) {
        result *= number;
    }

    public static void divide(double number) {
        if (number != 0) {
            result /= number;
        } else {
            System.out.println("Cannot divide by zero.");
        }
    }
}
