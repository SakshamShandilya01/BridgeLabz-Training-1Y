package com.gla.MultiThreading;
class BankAccount implements Runnable {

    private String accountHolder;
    private String accountType;

    public BankAccount(String accountHolder, String accountType) {
        this.accountHolder = accountHolder;
        this.accountType = accountType;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 3; i++) {
            System.out.println(
                    accountHolder + " (" + accountType + ")" +
                            " is checking balance | Thread Priority: " +
                            Thread.currentThread().getPriority() +
                            " | Check #" + i
            );

            try {
                Thread.sleep(2000); // 2 seconds delay
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
public class BankSimulation {

    public static void main(String[] args) {

        BankAccount premiumUser = new BankAccount("Rahul", "Premium");
        BankAccount regularUser = new BankAccount("Aman", "Regular");
        BankAccount basicUser = new BankAccount("Riya", "Basic");

        Thread t1 = new Thread(premiumUser);
        Thread t2 = new Thread(regularUser);
        Thread t3 = new Thread(basicUser);

        // Setting thread priorities
        t1.setPriority(10); // Premium
        t2.setPriority(5);  // Regular
        t3.setPriority(1);  // Basic

        // Starting threads
        t1.start();
        t2.start();
        t3.start();
    }
}
