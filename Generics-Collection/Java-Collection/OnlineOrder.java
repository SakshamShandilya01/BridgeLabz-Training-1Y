import java.util.*;

class OnlineOrder {
    int id;
    String name;

    Order(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Object o) {
        return (o instanceof Order) && this.id == ((Order) o).id;
    }

    public int hashCode() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {


        List<Order> list = new ArrayList<>();
        list.add(new Order(1, "Laptop"));
        list.add(new Order(2, "Phone"));
        list.add(new Order(1, "Duplicate"));

    
        Set<Order> set = new HashSet<>(list);

        Queue<Order> queue = new LinkedList<>(set);

    Stack<Order> stack = new Stack<>();

        while (!queue.isEmpty()) {
            Order o = queue.poll();
            if (o.id % 2 == 0) stack.push(o); // fail condition
            else System.out.println("Processed: " + o.id);
        }


        while (!stack.isEmpty()) {
            System.out.println("Retry: " + stack.pop().id);
        }
    }
}