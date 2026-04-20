package com.gla.StreamAPI;
import java.util.*;
import java.util.stream.Collectors;

class Invoice {
    String id;
    Invoice(String id) { this.id = id; }

    public String toString() {
        return "Invoice ID: " + id;
    }
}

public class InvoiceCreation {
    public static void main(String[] args) {
        List<String> ids = Arrays.asList("T1", "T2", "T3");
        List<Invoice> invoices = ids.stream().map(Invoice::new).collect(Collectors.toList());
        invoices.forEach(System.out::println);
    }
}