package com.gla.inheritancepolymorphism.AssistedProblems;

class Vehicle {

    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle {

    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
        System.out.println();
    }
}

class Truck extends Vehicle {

    int loadCapacity;

    Truck(int maxSpeed, String fuelType, int loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity);
        System.out.println();
    }
}

class Motorcycle extends Vehicle {

    boolean hasGear;

    Motorcycle(int maxSpeed, String fuelType, boolean hasGear) {
        super(maxSpeed, fuelType);
        this.hasGear = hasGear;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Has Gear: " + hasGear);
        System.out.println();
    }
}

public class VehicleAndTransportSystem {

    public static void main(String[] args) {

        Vehicle[] v = new Vehicle[3];

        v[0] = new Car(180, "Petrol", 5);
        v[1] = new Truck(120, "Diesel", 1000);
        v[2] = new Motorcycle(150, "Petrol", true);

        for (Vehicle vehicle : v) {
            vehicle.displayInfo();
        }
    }
}
