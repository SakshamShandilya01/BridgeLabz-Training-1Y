package com.gla.interfacesabstraction.DefaultMethodsinInterfaces.SmartVehicleDashboard;

public interface Vehicle {

    void displaySpeed(int speed);

    // Default method (new feature)
    default void displayBattery() {
        System.out.println("Battery information not available.");
    }
}
