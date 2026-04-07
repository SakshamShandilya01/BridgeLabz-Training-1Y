package com.gla.WrapperClasses.level1;
import java.util.Scanner;
public class PrimitiveToWrapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking integer input from user
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        // Converting primitive int to Integer object (Wrapper class)
        Integer obj = Integer.valueOf(num);

        // Displaying both values
        System.out.println("Primitive int value: " + num);
        System.out.println("Integer object value: " + obj);

        sc.close();
    }
}

