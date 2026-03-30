package com.gla.MultiThreading;
import java.time.LocalTime;


class TemperatureSensor implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(LocalTime.now() + " | Temperature Sensor reading temperature | Priority: "
                    + Thread.currentThread().getPriority());
            try {
                Thread.sleep(5000); // 5 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}


class SecurityCamera extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(LocalTime.now() + " | Security Camera recording | Priority: "
                    + this.getPriority());
            try {
                Thread.sleep(3000); // 3 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}


class LightController implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(LocalTime.now() + " | Light Controller adjusting lights | Priority: "
                    + Thread.currentThread().getPriority());
            try {
                Thread.sleep(4000); // 4 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}


class DoorLockMonitor implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(LocalTime.now() + " | Door Lock Monitor checking locks | Priority: "
                    + Thread.currentThread().getPriority());
            try {
                Thread.sleep(6000); // 6 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
public class SmartHomeSystem {
    public static void main(String[] args) {


        TemperatureSensor temp = new TemperatureSensor();
        SecurityCamera camera = new SecurityCamera();
        LightController light = new LightController();
        DoorLockMonitor door = new DoorLockMonitor();


        Thread t1 = new Thread(temp);
        Thread t2 = camera;
        Thread t3 = new Thread(light);
        Thread t4 = new Thread(door);

        t2.setPriority(10);
        t1.setPriority(7);
        t3.setPriority(5);
        t4.setPriority(5);


        t1.start();
        t2.start();
        t3.start();
        t4.start();


        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("All Smart Home Devices have completed their cycles.");
    }
}


