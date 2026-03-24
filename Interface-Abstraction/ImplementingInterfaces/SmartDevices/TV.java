package com.gla.interfacesabstraction.ImplementingInterfaces.SmartDevices;


public class TV implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("TV is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is OFF");
    }
}
