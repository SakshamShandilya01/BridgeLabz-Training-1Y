package com.gla.interfacesabstraction.ImplementingInterfaces.payment;


public class Wallet implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Wallet.");
    }
}
