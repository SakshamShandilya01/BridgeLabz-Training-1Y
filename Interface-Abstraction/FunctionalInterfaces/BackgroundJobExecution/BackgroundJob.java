package com.gla.interfacesabstraction.FunctionalInterfaces.BackgroundJobExecution;


public class BackgroundJob {

    public static void main(String[] args) {

        // Runnable using lambda
        Runnable task = () -> {
            System.out.println("Background job started...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Background job completed!");
        };

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Main thread continues...");
    }
}
