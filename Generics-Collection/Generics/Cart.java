import java.util.*;


class Cart<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}

class Electronics {
    String name;
    Electronics(String name) { this.name = name; }
    public String toString() { return "Electronics: " + name; }
}

class Clothing {
    String name;
    Clothing(String name) { this.name = name; }
    public String toString() { return "Clothing: " + name; }
}


public class Main {
    public static void main(String[] args) {

      
        Cart<Electronics> eCart = new Cart<>();
        eCart.addItem(new Electronics("Laptop"));
        eCart.addItem(new Electronics("Phone"));
        eCart.displayItems();


        Cart<Clothing> cCart = new Cart<>();
        cCart.addItem(new Clothing("Shirt"));
        cCart.addItem(new Clothing("Jeans"));
        cCart.displayItems();
    }
}