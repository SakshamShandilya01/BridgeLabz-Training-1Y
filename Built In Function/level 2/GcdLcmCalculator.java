package com.gla.ExtrasBuiltinFunction.level2;
import java.util.Scanner;
public class GcdLcmCalculator {
    static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("GCD = " + findGCD(a, b));
        System.out.println("LCM = " + findLCM(a, b));

        sc.close();
    }


}
