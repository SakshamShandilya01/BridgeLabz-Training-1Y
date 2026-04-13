import java.util.*;

public class Ride-Sharing {
    public static void main(String[] args) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        Set<Integer> drivers = new HashSet<>(Arrays.asList(1,2));
        List<String> completed = new ArrayList<>();

        // requests: {id, priority}
        pq.add(new int[]{101,1});
        pq.add(new int[]{102,3});

        while(!pq.isEmpty() && !drivers.isEmpty()) {
            int[] r = pq.poll();
            int d = drivers.iterator().next();
            drivers.remove(d);

            completed.add("Ride " + r[0] + " -> Driver " + d);
            System.out.println("Assigned: " + r[0] + " -> " + d);
        }

        System.out.println("Total: " + completed.size());
    }
}