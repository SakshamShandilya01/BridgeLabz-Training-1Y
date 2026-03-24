class Order {
    static int deliveryCharge = 40;
    int orderId;
    double baseAmount;

    Order(int id, double amt) {
        orderId = id;
        baseAmount = amt;
    }

    double calculateBill() {
        return baseAmount + deliveryCharge;
    }
}

class PremiumOrder extends Order {
    PremiumOrder(int id, double amt) {
        super(id, amt);
    }

    double calculateBill() {
        return baseAmount * 0.8 + deliveryCharge;
    }
}

public class Story2_Order {
    public static void main(String[] args) {
        Order o1 = new Order(1, 500);
        Order o2 = new PremiumOrder(2, 500);

        System.out.println(o1.calculateBill());
        System.out.println(o2.calculateBill());
    }
}