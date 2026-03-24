package com.gla.interfacesabstraction.DefaultMethodsinInterfaces.SmartVehicleDashboard;

public class DashboardApp {

    public static void main(String[] args) {

        Vehicle car = new Car();
        Vehicle ev = new ElectricCar();

        car.displaySpeed(90);
        car.displayBattery();

        ev.displaySpeed(120);
        ev.displayBattery();
    }
}
