package com.gla.StreamAPI;
import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public String toString() {
        return name + " Price:" + price + " Rating:" + rating + " Discount:" + discount;
    }
}

public class ECommerceSorting {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Laptop", 50000, 4.5, 10));
        list.add(new Product("Phone", 20000, 4.2, 15));
        list.add(new Product("Tablet", 30000, 4.7, 5));

        list.sort((a, b) -> Double.compare(a.price, b.price));
        System.out.println("Sorted by Price:");
        list.forEach(System.out::println);

        list.sort((a, b) -> Double.compare(b.rating, a.rating));
        System.out.println("Sorted by Rating:");
        list.forEach(System.out::println);
    }
}