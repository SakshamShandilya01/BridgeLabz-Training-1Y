
class BookCategory {}
class ClothingCategory {}
class GadgetCategory {}

class Product<T> {
    String name;
    double price;
    T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return name + " - Price: " + price;
    }
}


public class Main {

   
    public static <T extends Product<?>> void applyDiscount(T product, double percent) {
        double newPrice = product.price - (product.price * percent / 100);
        product.setPrice(newPrice);
    }

    public static void main(String[] args) {

        Product<BookCategory> book = new Product<>("Java Book", 500, new BookCategory());
        Product<ClothingCategory> cloth = new Product<>("T-Shirt", 1000, new ClothingCategory());
        Product<GadgetCategory> gadget = new Product<>("Phone", 20000, new GadgetCategory());

        applyDiscount(book, 10);
        applyDiscount(cloth, 20);
        applyDiscount(gadget, 5);

        System.out.println(book);
        System.out.println(cloth);
        System.out.println(gadget);
    }
}