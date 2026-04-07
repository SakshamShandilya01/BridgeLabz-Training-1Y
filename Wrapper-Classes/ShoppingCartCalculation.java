package com.gla.WrapperClasses.level1;

public class ShoppingCartCalculation {
    public static void main(String[] args) {

        // Prices stored as strings
        String[] prices = {"250", "499", "99", "abc"};

        int total = 0;

        for (String price : prices) {
            try {
                // Convert String to int using wrapper class
                int value = Integer.parseInt(price);
                total += value;
            } catch (NumberFormatException e) {
                // Handle invalid price
                System.out.println("Invalid price skipped: " + price);
            }
        }

        // Display total
        System.out.println("Total price = " + total);
    }
}
