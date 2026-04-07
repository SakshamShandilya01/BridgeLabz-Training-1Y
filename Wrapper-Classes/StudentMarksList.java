package com.gla.WrapperClasses.level1;
import java.util.ArrayList;
public class StudentMarksList {
    public static void main(String[] args) {

        // Mixed input (String, int, Integer, invalid)
        Object[] inputs = {"85", 95, Integer.valueOf(88), "null", "abc"};

        ArrayList<Integer> validMarks = new ArrayList<>();

        for (Object input : inputs) {
            try {
                if (input == null) {
                    continue;
                }

                // If input is String
                if (input instanceof String) {
                    String str = (String) input;

                    // Ignore "null" string
                    if (str.equalsIgnoreCase("null")) {
                        continue;
                    }

                    int value = Integer.parseInt(str);
                    validMarks.add(value);
                }
                // If input is Integer
                else if (input instanceof Integer) {
                    validMarks.add((Integer) input);
                }
                // If input is int (auto-boxed already in Object[])
                else if (input instanceof Number) {
                    validMarks.add(((Number) input).intValue());
                }

            } catch (NumberFormatException e) {
                // Ignore invalid values like "abc"
            }
        }

        // Calculate average
        int sum = 0;
        for (Integer mark : validMarks) {
            sum += mark; // auto-unboxing
        }

        double average = validMarks.size() > 0 ? (double) sum / validMarks.size() : 0.0;

        // Output
        System.out.println("Valid Marks: " + validMarks);
        System.out.println("Average Marks = " + average);
    }
}
