package com.gla.ExtrasBuiltinFunction.level2;
import java.time.LocalDate;
import java.util.Scanner;

public class DateComparisionExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first date (YYYY-MM-DD): ");
        LocalDate date1 = LocalDate.parse(sc.nextLine());

        System.out.print("Enter second date (YYYY-MM-DD): ");
        LocalDate date2 = LocalDate.parse(sc.nextLine());

        if (date1.isBefore(date2)) {
            System.out.println("First date is before second date.");
        }
        else if (date1.isAfter(date2)) {
            System.out.println("First date is after second date.");
        }
        else if (date1.isEqual(date2)) {
            System.out.println("Both dates are the same.");
        }

        sc.close();
    }


}
