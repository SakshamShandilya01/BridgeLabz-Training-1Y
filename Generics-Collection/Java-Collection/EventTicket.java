import java.util.*;

public class EventTicket {
    public static void main(String[] args) {

        List<String> bookings = new ArrayList<>();
        Set<String> users = new HashSet<>();
        Queue<String[]> q = new LinkedList<>();
        PriorityQueue<String[]> pq =
                new PriorityQueue<>((a,b)->b[1].compareTo(a[1])); // VIP first

        // register + booking {user, type}
        if(users.add("A")) q.add(new String[]{"A","normal"});
        if(users.add("B")) q.add(new String[]{"B","VIP"});

        pq.addAll(q); // move to priority queue

        // confirm bookings
        while(!pq.isEmpty()) {
            String[] b = pq.poll();
            bookings.add(b[0]);
            System.out.println("Confirmed: " + b[0] + " (" + b[1] + ")");
        }

        System.out.println("All bookings: " + bookings);
    }
}