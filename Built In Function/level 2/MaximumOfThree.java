package com.gla.ExtrasBuiltinFunction.level2;
import java.util.Scanner;
public class MaximumOfThree {
    static int getInput(Scanner sc) {
        return sc.nextInt();
    }

    static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max)
            max = b;
        if (c > max)
            max = c;
        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = getInput(sc);

        System.out.print("Enter second number: ");
        int b = getInput(sc);

        System.out.print("Enter third number: ");
        int c = getInput(sc);

        int max = findMaximum(a, b, c);

        System.out.println("Maximum number is: " + max);

        sc.close();
    }

}
