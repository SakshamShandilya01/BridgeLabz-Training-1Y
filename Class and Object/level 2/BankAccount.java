package com.gla.objectandclasses.Level2;

class BankAccount {

    String accountHolder;
    int accountNumber;
    double balance;

    public BankAccount(String holder, int number, double balance) {
        this.accountHolder = holder;
        this.accountNumber = number;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount b1 =
                new BankAccount("Rahul", 1001, 5000);

        b1.deposit(2000);
        b1.withdraw(3000);
        b1.displayBalance();
    }
}

