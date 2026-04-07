package com.gla.WrapperClasses.level1;
import java.util.ArrayList;
import java.util.Objects;
public class ProductRatingAnalyzer {
    public static void main(String[] args) {

        // Primitive ratings
        int[] primitiveRatings = {4, 5, 3, 4};

        // Wrapper ratings (with a null value)
        ArrayList<Integer> wrapperRatings = new ArrayList<>();
        wrapperRatings.add(5);
        wrapperRatings.add(null);
        wrapperRatings.add(3);

        // Combined list
        ArrayList<Integer> allRatings = new ArrayList<>();

        // Add primitive array (auto-boxing)
        for (int rating : primitiveRatings) {
            allRatings.add(rating);
        }

        // Add wrapper list (including nulls)
        allRatings.addAll(wrapperRatings);

        // Calculate average (ignore nulls)
        int sum = 0;
        int count = 0;

        for (Integer rating : allRatings) {
            if (Objects.nonNull(rating)) {
                sum += rating; // auto-unboxing
                count++;
            }
        }

        double average = (count > 0) ? (double) sum / count : 0.0;

        // Output
        System.out.println("All Ratings: " + allRatings);
        System.out.println("Average Rating = " + average);
    }
}
