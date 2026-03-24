package com.gla.inheritancepolymorphism.AssistedProblems;

class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {

    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says Bark");
    }
}

class Cat extends Animal {

    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says Meow");
    }
}

class Bird extends Animal {

    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says Chirp");
    }
}

public class AnimalHierarchy {

    public static void main(String[] args) {

        Animal a1 = new Dog("Tommy", 3);
        Animal a2 = new Cat("Kitty", 2);
        Animal a3 = new Bird("Mithu", 1);

        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}