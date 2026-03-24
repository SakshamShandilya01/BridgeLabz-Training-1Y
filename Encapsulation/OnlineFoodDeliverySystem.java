
// Interface Discountable
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    protected double price;
    protected int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method
    abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {

    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Discount: 10%";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {

    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    double calculateTotalPrice() {
        return (price * quantity) + 50; // extra charge
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Discount: 5%";
    }
}

// Main class
public class OnlineFoodDeliverySystem {

    public static void main(String[] args) {

        FoodItem[] items = {
                new VegItem("VegItem1", 200, 2),
                new NonVegItem("NonVegItem1", 300, 1)
        };

        for (FoodItem item : items) {

            item.getItemDetails();

            double total = item.calculateTotalPrice();
            Discountable d = (Discountable) item;
            double discount = d.applyDiscount();

            System.out.println("Total Price: " + total);
            System.out.println("Discount: " + discount);
            System.out.println("Final Price: " + (total - discount));
            System.out.println("----------------------");
        }
    }
}