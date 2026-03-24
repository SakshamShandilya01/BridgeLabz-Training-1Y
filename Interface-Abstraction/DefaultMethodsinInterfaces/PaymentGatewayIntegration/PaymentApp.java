package com.gla.interfacesabstraction.DefaultMethodsinInterfaces.PaymentGatewayIntegration;


public class PaymentApp {

    public static void main(String[] args) {

        PaymentProcessor razorpay = new Razorpay();
        PaymentProcessor paypal = new PayPal();

        razorpay.processPayment(1000);
        razorpay.refund(200);

        paypal.processPayment(2000);
        paypal.refund(500);
    }
}
