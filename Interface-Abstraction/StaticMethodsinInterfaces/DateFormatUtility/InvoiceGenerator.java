package com.gla.interfacesabstraction.StaticMethodsinInterfaces.DateFormatUtility;



import java.time.LocalDate;

public class InvoiceGenerator {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        String formatted1 =
                DateUtils.formatDate(today, "dd-MM-yyyy");

        String formatted2 =
                DateUtils.formatDate(today, "yyyy/MM/dd");

        System.out.println("Format 1: " + formatted1);
        System.out.println("Format 2: " + formatted2);
    }
}
