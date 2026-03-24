package com.gla.interfacesabstraction.ImplementingInterfaces.SmartDevices;

public class Light implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("Light is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is OFF");
    }
}
