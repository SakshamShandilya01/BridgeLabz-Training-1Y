package com.gla.interfacesabstraction.ImplementingInterfaces.vehiclerental;

public class Car implements RentalService {

    @Override
    public void rent() {
        System.out.println("Car rented successfully.");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Car returned successfully.");
    }
}
