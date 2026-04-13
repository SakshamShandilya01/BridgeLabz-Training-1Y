import java.util.*;

public class InventoryRestock  {
    public static void main(String[] args) {

        Set<String> names = new HashSet<>();
        List<String[]> products = new ArrayList<>(); // {name, price, stock}
        Queue<String[]> restock = new LinkedList<>();
        Stack<String[]> stack = new Stack<>();


        if(names.add("Milk")) products.add(new String[]{"Milk","50","2"});
        if(names.add("Bread")) products.add(new String[]{"Bread","30","10"});

        for(String[] p : products)
            if(Integer.parseInt(p[2]) < 5) restock.add(p);

  
        while(!restock.isEmpty()) {
            String[] p = restock.poll();
            p[2] = "10"; // restocked
            stack.push(p);
            System.out.println("Restocked: " + p[0]);
        }

        
        if(!stack.isEmpty()) {
            String[] p = stack.pop();
            p[2] = "2"; // rollback
            System.out.println("Undo: " + p[0]);
        }
    }
}