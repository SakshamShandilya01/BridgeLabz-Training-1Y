package com.gla.interfacesabstraction.MarkerInterfaces.CloningPrototypeObjects;



public class CloneApp {

    public static void main(String[] args) {

        try {
            Product p1 = new Product("Laptop", 50000);
            Product p2 = (Product) p1.clone();

            p1.display();
            p2.display();

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported.");
        }
    }
}
