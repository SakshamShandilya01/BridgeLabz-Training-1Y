package com.gla.ExtrasBuiltinFunction.level2;
import java.util.Scanner;
public class BasicCalculator {
    static double add(double a, double b) {
        return a + b;
    }

    static double subtract(double a, double b) {
        return a - b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        System.out.print("Choose operation: ");
        int choice = sc.nextInt();

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        switch (choice) {
            case 1:
                System.out.println("Result = " + add(a, b));
                break;
            case 2:
                System.out.println("Result = " + subtract(a, b));
                break;
            case 3:
                System.out.println("Result = " + multiply(a, b));
                break;
            case 4:
                System.out.println("Result = " + divide(a, b));
                break;
        }

        sc.close();
    }


}
