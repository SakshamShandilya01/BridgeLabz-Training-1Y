package com.gla.inheritancepolymorphism.MultilevelInheritance;

class Order {

    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {

    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {

    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered";
    }
}

public class OnlineRetailSystem {

    public static void main(String[] args) {

        Order o1 = new Order(101, "10-Mar-2026");
        Order o2 = new ShippedOrder(102, "11-Mar-2026", "TRK123");
        Order o3 = new DeliveredOrder(103, "12-Mar-2026", "TRK456", "14-Mar-2026");

        System.out.println("Order 1 Status: " + o1.getOrderStatus());
        System.out.println("Order 2 Status: " + o2.getOrderStatus());
        System.out.println("Order 3 Status: " + o3.getOrderStatus());
    }
}