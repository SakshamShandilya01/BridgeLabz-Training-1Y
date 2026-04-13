import java.util.*;


abstract class Warehouse {
    String name;

    WarehouseItem(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}


class Electronics extends WarehouseItem {
    Electronics(String name) { super(name); }
}

class Groceries extends WarehouseItem {
    Groceries(String name) { super(name); }
}

class Furniture extends WarehouseItem {
    Furniture(String name) { super(name); }
}


class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}


class Main {

    public static void displayItems(List<? extends WarehouseItem> list) {
        for (WarehouseItem item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {

        Storage<Electronics> eStore = new Storage<>();
        eStore.addItem(new Electronics("TV"));
        eStore.addItem(new Electronics("Laptop"));

        Storage<Groceries> gStore = new Storage<>();
        gStore.addItem(new Groceries("Rice"));
        gStore.addItem(new Groceries("Milk"));

        displayItems(eStore.getItems());
        displayItems(gStore.getItems());
    }
}