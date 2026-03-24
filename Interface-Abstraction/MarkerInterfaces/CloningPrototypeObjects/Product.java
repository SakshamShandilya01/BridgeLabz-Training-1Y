package com.gla.interfacesabstraction.MarkerInterfaces.CloningPrototypeObjects;


public class Product implements Cloneable {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void display() {
        System.out.println("Product: " + name + ", Price: " + price);
    }
}
