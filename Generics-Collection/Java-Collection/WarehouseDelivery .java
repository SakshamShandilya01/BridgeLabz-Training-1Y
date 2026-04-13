import java.util.*;

public class WarehouseDelivery {
    public static void main(String[] args) {

        Queue<String[]> q = new LinkedList<>(); // {id, status}
        Set<String> ids = new HashSet<>();
        List<String> delivered = new ArrayList<>();
        Stack<String> returned = new Stack<>();

        
        if(ids.add("P1")) q.add(new String[]{"P1","ok"});
        if(ids.add("P2")) q.add(new String[]{"P2","fail"});


        while(!q.isEmpty()) {
            String[] p = q.poll();
            if(p[1].equals("ok")) delivered.add(p[0]);
            else returned.push(p[0]);
        }

       
        System.out.println("Delivered: " + delivered);
        System.out.println("Returned: " + returned);
    }
}