import java.util.*;

public class Library {
    public static void main(String[] args) {

        List<String> books = new ArrayList<>();
        Set<String> members = new HashSet<>();
        Queue<String> issue = new LinkedList<>();
        Stack<String> returned = new Stack<>();

        
        books.add("Java");
        books.add("DSA");

        
        members.add("M1");
        members.add("M1"); // duplicate ignored

 
        issue.add("Java");
        issue.add("DSA");

        while(!issue.isEmpty()) {
            String b = issue.poll();
            System.out.println("Issued: " + b);
            returned.push(b); // simulate return
        }

      
        if(!returned.isEmpty())
            System.out.println("Reissued: " + returned.pop());
    }
}