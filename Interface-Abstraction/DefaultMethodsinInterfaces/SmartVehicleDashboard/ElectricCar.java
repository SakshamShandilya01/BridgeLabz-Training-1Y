package com.gla.interfacesabstraction.DefaultMethodsinInterfaces.SmartVehicleDashboard;

public class ElectricCar implements Vehicle {

    @Override
    public void displaySpeed(int speed) {
        System.out.println("Electric Car Speed: " + speed + " km/h");
    }

    @Override
    public void displayBattery() {
        System.out.println("Battery Level: 80%");
    }
}
