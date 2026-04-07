package com.gla.WrapperClasses.level1;

public class AgeValidator {
    public static boolean isValidAge(String input) {
        try {
            int age = Integer.parseInt(input); // convert String → int

            if (age >= 18) {
                return true;
            } else {
                return false;
            }

        } catch (NumberFormatException e) {
            return false; // invalid number
        }
    }

    public static void main(String[] args) {

        // Test cases
        String[] inputs = {"20", "17", "abc", "18"};

        for (String input : inputs) {
            System.out.println("Input: " + input + " -> Valid: " + isValidAge(input));
        }
    }
}
