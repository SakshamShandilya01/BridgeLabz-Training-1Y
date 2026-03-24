package com.gla.interfacesabstraction.StaticMethodsinInterfaces.UnitConversionTool;



public class ConversionApp {

    public static void main(String[] args) {

        double miles = UnitConverter.kmToMiles(10);
        double lbs = UnitConverter.kgToLbs(5);

        System.out.println("10 km = " + miles + " miles");
        System.out.println("5 kg = " + lbs + " lbs");
    }
}
