package com.gla.inheritancepolymorphism.SingleInheritance;

class Device {

    int deviceId;
    String status;

    Device(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

class Thermostat extends Device {

    int temperatureSetting;

    Thermostat(int deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class SmartHomeSystem {

    public static void main(String[] args) {

        Thermostat t1 = new Thermostat(101, "ON", 24);

        t1.displayStatus();
    }
}
