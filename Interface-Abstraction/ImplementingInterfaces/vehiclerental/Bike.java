package com.gla.interfacesabstraction.ImplementingInterfaces.vehiclerental;


public class Bike implements RentalService {

    @Override
    public void rent() {
        System.out.println("Bike rented successfully.");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bike returned successfully.");
    }
}
