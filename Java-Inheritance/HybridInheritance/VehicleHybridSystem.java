package com.gla.inheritancepolymorphism.HybridInheritance;

class Vehicle {

    int maxSpeed;
    String model;

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    void displayVehicle() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed);
    }
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {

    ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    void charge() {
        System.out.println("Electric Vehicle is charging");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {

    PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void refuel() {
        System.out.println("Petrol Vehicle is refueling");
    }
}

public class VehicleHybridSystem {

    public static void main(String[] args) {

        ElectricVehicle ev = new ElectricVehicle(180, "Tesla");
        PetrolVehicle pv = new PetrolVehicle(160, "Honda");

        ev.displayVehicle();
        ev.charge();
        System.out.println();

        pv.displayVehicle();
        pv.refuel();
    }
}