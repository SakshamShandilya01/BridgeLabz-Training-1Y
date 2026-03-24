package com.gla.interfacesabstraction.DefaultMethodsinInterfaces.SmartVehicleDashboard;

public class Car implements Vehicle {

    @Override
    public void displaySpeed(int speed) {
        System.out.println("Car Speed: " + speed + " km/h");
    }
}