package com.gla.ExtrasBuiltinFunction.level2;
import java.util.Scanner;
public class FactorialRecursion {
    static long factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    static int getInput(Scanner sc) {
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }

    static void displayResult(long result) {
        System.out.println("Factorial = " + result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = getInput(sc);
        long result = factorial(num);
        displayResult(result);
        sc.close();
    }



}
