package com.gla.ExtrasBuiltinFunction.level2;
import java.util.Scanner;
public class palidromeChecker {
    static String getInput(Scanner sc) {
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversed);
    }

    static void displayResult(boolean result) {
        if (result)
            System.out.println("It is a palindrome.");
        else
            System.out.println("It is not a palindrome.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = getInput(sc);
        boolean result = isPalindrome(input);
        displayResult(result);
        sc.close();
    }

}
