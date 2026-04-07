package com.gla.WrapperClasses.level1;
import java.util.Scanner;
public class WrapperToPrimitve {
    public static void main(String[] args) {

        // Given Double object
        Double obj = 45.67;

        // Converting to primitive double (unboxing)
        double d = obj;

        // Converting to primitive int (using casting)
        int i = (int) d;

        // Printing values
        System.out.println("Double object value: " + obj);
        System.out.println("Primitive double value: " + d);
        System.out.println("Primitive int value: " + i);
    }
}

