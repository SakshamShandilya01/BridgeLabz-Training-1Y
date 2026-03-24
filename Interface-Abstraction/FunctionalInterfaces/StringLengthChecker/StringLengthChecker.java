package com.gla.interfacesabstraction.FunctionalInterfaces.StringLengthChecker;


import java.util.function.Function;

public class StringLengthChecker {

    public static void main(String[] args) {

        int limit = 20;

        // Function to calculate string length
        Function<String, Integer> getLength =
                message -> message.length();

        String msg = "Hello Functional Interface";

        int length = getLength.apply(msg);

        System.out.println("Message Length: " + length);

        if (length > limit) {
            System.out.println("Message exceeds character limit!");
        } else {
            System.out.println("Message within limit.");
        }
    }
}
