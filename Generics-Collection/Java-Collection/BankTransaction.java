import java.util.*;

public class BankTransaction {
    public static void main(String[] args) {

        Queue<int[]> q = new LinkedList<>(); // {accId, amount}
        Set<Integer> valid = new HashSet<>(Arrays.asList(1,2));
        List<String> record = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();

        
        q.add(new int[]{1,100});
        q.add(new int[]{3,200}); // invalid

       
        while(!q.isEmpty()) {
            int[] t = q.poll();

            if(valid.contains(t[0])) {
                record.add("Done: " + t[0]);
                stack.push(t);
                System.out.println("Success: " + t[0]);
            } else {
                System.out.println("Invalid: " + t[0]);
            }
        }

       
        if(!stack.isEmpty()) {
            int[] r = stack.pop();
            System.out.println("Rollback: " + r[0]);
        }
    }
}