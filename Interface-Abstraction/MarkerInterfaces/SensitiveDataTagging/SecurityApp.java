package com.gla.interfacesabstraction.MarkerInterfaces.SensitiveDataTagging;

public class SecurityApp {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("1234567890");

        EncryptionProcessor.process(account);
    }
}
