package com.gla.interfacesabstraction.ImplementingInterfaces.vehiclerental;


public class VehicleRentalSystem {

    public static void main(String[] args) {

        RentalService car = new Car();
        RentalService bike = new Bike();
        RentalService bus = new Bus();

        car.rent();
        bike.rent();
        bus.rent();

        car.returnVehicle();
    }
}
