import java.util.*;

public class CourierDelivery {
    public static void main(String[] args) {

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b)->b[1]-a[1]); // high priority first
        Queue<int[]> q = new LinkedList<>(); // normal deliveries
        Set<Integer> ids = new HashSet<>();
        List<Integer> completed = new ArrayList<>();


        if(ids.add(1)) pq.add(new int[]{1,5});   // high priority
        if(ids.add(2)) q.add(new int[]{2,1});    // normal
        if(ids.add(3)) pq.add(new int[]{3,3});


        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            completed.add(p[0]);
            System.out.println("Delivered (Priority): " + p[0]);
        }

       
        while(!q.isEmpty()) {
            int[] p = q.poll();
            completed.add(p[0]);
            System.out.println("Delivered: " + p[0]);
        }

       
        System.out.println("All Delivered: " + completed);
    }
}