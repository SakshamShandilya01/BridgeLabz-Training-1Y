package com.gla.interfacesabstraction.ImplementingInterfaces.vehiclerental;



public class Bus implements RentalService {

    @Override
    public void rent() {
        System.out.println("Bus rented successfully.");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bus returned successfully.");
    }
}