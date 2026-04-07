package com.gla.WrapperClasses.level1;
import java.util.ArrayList;
public class WrapperInCollection {
    public static void main(String[] args) {

        // Given primitive array
        double[] prices = {10.5, 20.0, 35.75, 5.5};

        // Convert to ArrayList<Double> (auto-boxing)
        ArrayList<Double> list = new ArrayList<>();
        for (double price : prices) {
            list.add(price); // auto-boxing (double → Double)
        }

        // Find highest price and calculate average
        double max = list.get(0);
        double sum = 0;

        for (Double price : list) {
            if (price > max) {
                max = price;
            }
            sum += price; // auto-unboxing (Double → double)
        }

        double average = sum / list.size();

        // Print results
        System.out.println("Highest price = " + max);
        System.out.println("Average price = " + average);
    }
}
