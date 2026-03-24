package com.gla.interfacesabstraction.DefaultMethodsinInterfaces.PaymentGatewayIntegration;



public class PayPal implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of ₹" + amount + " via PayPal.");
    }

    // Overriding default method (optional)
    @Override
    public void refund(double amount) {
        System.out.println("Refund of ₹" + amount + " via PayPal processed.");
    }
}
