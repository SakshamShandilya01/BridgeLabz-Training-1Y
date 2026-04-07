package com.gla.WrapperClasses.level1;
import java.util.ArrayList;
public class AutoboxingExample {
    public static void main(String[] args) {

        // Creating ArrayList of Integer
        ArrayList<Integer> list = new ArrayList<>();

        // Adding values using auto-boxing (int → Integer)
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(5);

        // Calculating sum using auto-unboxing (Integer → int)
        int sum = 0;
        for (Integer num : list) {
            sum += num; // auto-unboxing happens here
        }

        // Printing result
        System.out.println("Sum of numbers = " + sum);
    }
}
