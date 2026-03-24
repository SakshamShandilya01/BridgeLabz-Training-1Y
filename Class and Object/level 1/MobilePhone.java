package com.gla.objectandclasses.Level1;

class MobilePhone {

    String brand;
    String model;
    double price;

    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        MobilePhone m1 =
                new MobilePhone("Samsung", "Galaxy S23", 75000);

        m1.displayDetails();
    }
}

