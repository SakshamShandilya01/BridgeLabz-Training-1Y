
// Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class
abstract class Product {
    private int productId;
    private String name;
    protected double price;

    public Product(int id, String name, double price) {
        this.productId = id;
        this.name = name;
        this.price = price;
    }

    abstract double calculateDiscount();

    public void displayProduct() {
        System.out.println("Product: " + name);
        System.out.println("Price: " + price);
    }
}

// Electronics class
class Electronics extends Product implements Taxable {

    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateDiscount() {
        return price * 0.10;
    }

    @Override
    public double calculateTax() {
        return price * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics GST: 18%";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {

    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateDiscount() {
        return price * 0.20;
    }

    @Override
    public double calculateTax() {
        return price * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing GST: 5%";
    }
}

// Main class (File name same as this)
public class EcommerceSystem {

    public static void main(String[] args) {

        Product p1 = new Electronics(1, "Laptop", 50000);
        Product p2 = new Clothing(2, "Jacket", 2000);

        Product[] products = {p1, p2};

        for (Product p : products) {

            p.displayProduct();

            double discount = p.calculateDiscount();
            double tax = ((Taxable) p).calculateTax();
            double finalPrice = p.price + tax - discount;

            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("----------------------");
        }
    }
}