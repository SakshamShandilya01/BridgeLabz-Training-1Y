package com.gla.objectandclasses.Level2;

class CartItem {

    String itemName;
    double price;
    int quantity;

    public void addItem(String name, double price, int qty) {
        this.itemName = name;
        this.price = price;
        this.quantity += qty;
    }

    public void removeItem(int qty) {
        if (qty <= quantity)
            quantity -= qty;
    }

    public double totalCost() {
        return price * quantity;
    }

    public void display() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + totalCost());
    }

    public static void main(String[] args) {
        CartItem c1 = new CartItem();

        c1.addItem("Shoes", 1500, 2);
        c1.removeItem(1);
        c1.display();
    }
}
