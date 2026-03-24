package com.gla.interfacesabstraction.DefaultMethodsinInterfaces.PaymentGatewayIntegration;


public class Razorpay implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of ₹" + amount + " via Razorpay.");
    }
}
