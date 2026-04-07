package com.gla.WrapperClasses.level1;

public class ShoppingCart {

    public static void main(String[] args) {

        // Prices stored as strings
        String[] prices = {"250", "499", "99", "abc"};

        int total = 0;

        for (String price : prices) {
            try {
                // Convert String to int
                int value = Integer.parseInt(price);
                total += value;
            } catch (NumberFormatException e) {
                // Handle invalid input
                System.out.println("Invalid price ignored: " + price);
            }
        }

        // Print total price
        System.out.println("Total price = " + total);
    }
}
