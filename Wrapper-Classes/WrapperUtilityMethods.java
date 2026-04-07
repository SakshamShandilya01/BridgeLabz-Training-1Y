package com.gla.WrapperClasses.level1;

public class WrapperUtilityMethods {
    public static void main(String[] args) {

        // String to primitive conversions
        int intValue = Integer.parseInt("123");
        double doubleValue = Double.parseDouble("3.14");
        boolean boolValue = Boolean.parseBoolean("true");

        // Integer to binary string
        String binary = Integer.toBinaryString(10);

        // Character methods
        boolean isDigit = Character.isDigit('5');
        char upper = Character.toUpperCase('a');

        // Printing results
        System.out.println("Integer.parseInt(\"123\") = " + intValue);
        System.out.println("Double.parseDouble(\"3.14\") = " + doubleValue);
        System.out.println("Boolean.parseBoolean(\"true\") = " + boolValue);
        System.out.println("Integer.toBinaryString(10) = " + binary);
        System.out.println("Character.isDigit('5') = " + isDigit);
        System.out.println("Character.toUpperCase('a') = " + upper);
    }
}
