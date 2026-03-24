package com.gla.inheritancepolymorphism.HybridInheritance;

class Person {

    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
    }
}

interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {

    Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("Chef cooks food");
    }
}

class Waiter extends Person implements Worker {

    Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("Waiter serves food");
    }
}

public class RestaurantSystem {

    public static void main(String[] args) {

        Chef c = new Chef("Rahul", 1);
        Waiter w = new Waiter("Aman", 2);

        c.displayPerson();
        c.performDuties();
        System.out.println();

        w.displayPerson();
        w.performDuties();
    }
}