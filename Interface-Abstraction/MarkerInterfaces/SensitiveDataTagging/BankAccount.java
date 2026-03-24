package com.gla.interfacesabstraction.MarkerInterfaces.SensitiveDataTagging;

public class BankAccount implements SensitiveData {

    private String accountNumber;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void display() {
        System.out.println("Account: " + accountNumber);
    }
}
