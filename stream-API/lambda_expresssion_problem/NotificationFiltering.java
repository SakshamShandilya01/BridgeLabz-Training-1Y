package com.gla.StreamAPI;
import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    Alert(String type) { this.type = type; }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(new Alert("Critical"), new Alert("General"), new Alert("Emergency"));

        Predicate<Alert> filter = a -> a.type.equals("Critical") || a.type.equals("Emergency");

        alerts.stream().filter(filter).forEach(a -> System.out.println(a.type));
    }
}