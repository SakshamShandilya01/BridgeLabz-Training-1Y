package com.gla.ExtrasBuiltinFunction.level1;
import java.time.LocalDate;
import java.util.Scanner;
public class DateArithmeticExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date (YYYY-MM-DD): ");
        String input = sc.nextLine();

        LocalDate date = LocalDate.parse(input);

        LocalDate result = date.plusDays(7)
                .plusMonths(1)
                .plusYears(2)
                .minusWeeks(3);

        System.out.println("Original Date: " + date);
        System.out.println("Final Date after calculations: " + result);

        sc.close();
    }


}
