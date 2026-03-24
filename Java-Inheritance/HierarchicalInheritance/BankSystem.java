package com.gla.inheritancepolymorphism.HierarchicalInheritance;

class BankAccount {

    int accountNumber;
    double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {

    double interestRate;

    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {

    double withdrawalLimit;

    CheckingAccount(int accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {

    int depositYears;

    FixedDepositAccount(int accountNumber, double balance, int depositYears) {
        super(accountNumber, balance);
        this.depositYears = depositYears;
    }

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Deposit Years: " + depositYears);
    }
}

public class BankSystem {

    public static void main(String[] args) {

        SavingsAccount s = new SavingsAccount(101, 50000, 5);
        CheckingAccount c = new CheckingAccount(102, 30000, 10000);
        FixedDepositAccount f = new FixedDepositAccount(103, 100000, 3);

        s.displayDetails();
        s.displayAccountType();
        System.out.println();

        c.displayDetails();
        c.displayAccountType();
        System.out.println();

        f.displayDetails();
        f.displayAccountType();
    }
}
