class Product {
    int id;
    String name;

    Product(int i, String n) {
        id = i;
        name = n;
    }

    boolean isMatch(String key) {
        return name.toLowerCase().contains(key.toLowerCase());
    }
}

class ElectronicProduct extends Product {
    String brand;

    ElectronicProduct(int i, String n, String b) {
        super(i, n);
        brand = b;
    }

    boolean isMatch(String key) {
        return super.isMatch(key) || brand.toLowerCase().contains(key.toLowerCase());
    }
}

public class Story5_Product {
    public static void main(String[] args) {
        ElectronicProduct p = new ElectronicProduct(1, "Phone", "Samsung");
        System.out.println(p.isMatch("sam"));
    }
}