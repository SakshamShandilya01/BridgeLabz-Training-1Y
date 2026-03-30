package com.gla.MultiThreading;
class Order implements Runnable {

    private int orderId;
    private String restaurantName;
    private int deliveryTime; // in seconds

    public Order(int orderId, String restaurantName, int deliveryTime) {
        this.orderId = orderId;
        this.restaurantName = restaurantName;
        this.deliveryTime = deliveryTime;
    }

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();
        String agent = Thread.currentThread().getName();

        try {
            System.out.println("Agent: " + agent +
                    " | Order " + orderId + " from " + restaurantName +
                    " → Picked up");

            Thread.sleep(1000);

            System.out.println("Agent: " + agent +
                    " | Order " + orderId +
                    " → In Transit");

            Thread.sleep(deliveryTime * 1000);

            System.out.println("Agent: " + agent +
                    " | Order " + orderId +
                    " → Delivered");

        } catch (InterruptedException e) {
            System.out.println(e);
        }

        long endTime = System.currentTimeMillis();
        long totalTime = (endTime - startTime) / 1000;

        System.out.println("Order " + orderId +
                " delivered in " + totalTime +
                " seconds by " + agent + "\n");
    }
}
public class FoodDeliverySystem {
    public static void main(String[] args) {

        Order o1 = new Order(101, "Pizza Hut", 4);
        Order o2 = new Order(102, "Dominos", 5);
        Order o3 = new Order(103, "KFC", 3);
        Order o4 = new Order(104, "Burger King", 6);
        Order o5 = new Order(105, "Subway", 2);

        Thread t1 = new Thread(o1, "Agent-A (Express)");
        Thread t2 = new Thread(o2, "Agent-B (Standard)");
        Thread t3 = new Thread(o3, "Agent-C (Express)");
        Thread t4 = new Thread(o4, "Agent-D (Economy)");
        Thread t5 = new Thread(o5, "Agent-E (Standard)");

        // Setting priorities
        t1.setPriority(10); // Express
        t3.setPriority(10); // Express
        t2.setPriority(5);  // Standard
        t5.setPriority(5);  // Standard
        t4.setPriority(3);  // Economy

        // Start delivery threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}


