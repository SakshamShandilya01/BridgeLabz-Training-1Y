package com.gla.interfacesabstraction.DefaultMethodsinInterfaces.PaymentGatewayIntegration;



public interface PaymentProcessor {

    void processPayment(double amount);

    // New feature added later
    default void refund(double amount) {
        System.out.println("Refund of ₹" + amount + " initiated (Default Process).");
    }
}
