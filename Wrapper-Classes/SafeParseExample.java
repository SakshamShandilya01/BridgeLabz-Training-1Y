package com.gla.WrapperClasses.level1;

public class SafeParseExample {
    // Method to safely parse String to int
    public static int safeParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // return -1 if conversion fails
        }
    }

    public static void main(String[] args) {

        // Test inputs
        String[] inputs = {"123", "abc", "45.6", "0"};

        for (String input : inputs) {
            int result = safeParseInt(input);
            System.out.println("Input: " + input + " -> Output: " + result);
        }
    }
}
