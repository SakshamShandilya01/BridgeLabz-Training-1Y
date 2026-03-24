package com.gla.interfacesabstraction.ImplementingInterfaces.SmartDevices;

public class AC implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("AC is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("AC is OFF");
    }
}
