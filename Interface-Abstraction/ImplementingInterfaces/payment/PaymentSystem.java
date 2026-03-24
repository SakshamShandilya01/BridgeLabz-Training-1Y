package com.gla.interfacesabstraction.ImplementingInterfaces.payment;



public class PaymentSystem {

    public static void main(String[] args) {

        Payment upi = new UPI();
        Payment card = new CreditCard();
        Payment wallet = new Wallet();

        upi.pay(500);
        card.pay(1200);
        wallet.pay(300);
    }
}
