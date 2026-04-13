import java.util.*;

public class Hospital {
    public static void main(String[] args) {

        Set<Integer> admitted = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> discharged = new Stack<>();
        List<Integer> history = new ArrayList<>();

        
        if(admitted.add(1)) queue.add(1);
        if(admitted.add(2)) queue.add(2);


        while(!queue.isEmpty()) {
            int p = queue.poll();
            history.add(p);
            discharged.push(p);
            System.out.println("Treated: " + p);
        }

       
        if(!discharged.isEmpty()) {
            int p = discharged.pop();
            queue.add(p);
            System.out.println("Re-admitted: " + p);
        }
    }
}