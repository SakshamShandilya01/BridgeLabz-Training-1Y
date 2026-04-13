import java.util.*;

public class customerFeedback {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        
        list.add("Good app");
        list.add("Nice UI");
        list.add("Good app"); // duplicate


        for(String f : list)
            if(set.add(f)) queue.add(f);

  
        while(!queue.isEmpty()) {
            String f = queue.poll();
            System.out.println("Processed: " + f);
            stack.push(f);
        }

   
        System.out.println("Recent:");
        while(!stack.isEmpty())
            System.out.println(stack.pop());
    }
}