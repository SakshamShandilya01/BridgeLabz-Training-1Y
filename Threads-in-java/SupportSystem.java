package com.gla.MultiThreading;
import java.util.*;

class Ticket extends Thread {

    int ticketNo;
    String type;
    int priority;

    static long totalTime = 0;
    static int count = 0;

    static Map<Integer, List<Long>> waitStats = new HashMap<>();

    Ticket(int ticketNo, String type, int priority, String agentName) {
        this.ticketNo = ticketNo;
        this.type = type;
        this.priority = priority;
        setName(agentName);
        setPriority(priority);

        waitStats.putIfAbsent(priority, new ArrayList<>());
    }

    public void run() {

        try {
            long start = System.currentTimeMillis();

            System.out.println("Ticket #" + ticketNo +
                    " | Type: " + type +
                    " | Agent: " + getName() +
                    " | Priority: " + getPriority() +
                    " | Processing Started");

            int processTime = new Random().nextInt(5) + 1;
            Thread.sleep(processTime * 1000);

            long end = System.currentTimeMillis();
            long duration = (end - start) / 1000;

            synchronized (Ticket.class) {
                totalTime += duration;
                count++;
                waitStats.get(priority).add(duration);
            }

            System.out.println("Ticket #" + ticketNo +
                    " | Completed by " + getName() +
                    " | Time: " + duration + " sec");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class SupportSystem {

    public static void main(String[] args) throws Exception {

        Ticket[] tickets = new Ticket[10];

        tickets[0] = new Ticket(1, "Critical Bug", 10, "Agent-A");
        tickets[1] = new Ticket(2, "Feature Request", 4, "Agent-B");
        tickets[2] = new Ticket(3, "General Query", 2, "Agent-C");
        tickets[3] = new Ticket(4, "Feedback", 1, "Agent-D");
        tickets[4] = new Ticket(5, "Critical Bug", 10, "Agent-E");
        tickets[5] = new Ticket(6, "General Query", 2, "Agent-F");
        tickets[6] = new Ticket(7, "Feature Request", 4, "Agent-G");
        tickets[7] = new Ticket(8, "Feedback", 1, "Agent-H");
        tickets[8] = new Ticket(9, "Critical Bug", 10, "Agent-I");
        tickets[9] = new Ticket(10, "General Query", 2, "Agent-J");

        System.out.println("Queue Order (Based on Priority):");
        Arrays.sort(tickets, (a, b) -> b.priority - a.priority);

        for (int i = 0; i < tickets.length; i++) {
            System.out.println("Position " + (i + 1) +
                    " → Ticket #" + tickets[i].ticketNo +
                    " (" + tickets[i].type + ")");
        }

        System.out.println("\nProcessing Tickets...\n");

        for (Ticket t : tickets) {
            t.start();
        }

        for (Ticket t : tickets) {
            t.join();
        }

        System.out.println("\nAll Tickets Processed");

        System.out.println("Total Processing Time: " + Ticket.totalTime + " sec");

        System.out.println("\nAverage Time per Priority:");

        for (int p : Ticket.waitStats.keySet()) {

            List<Long> list = Ticket.waitStats.get(p);
            long sum = 0;

            for (long t : list) {
                sum += t;
            }

            double avg = (double) sum / list.size();

            System.out.println("Priority " + p +
                    " → Avg Time: " + avg + " sec");
        }
    }
}


