import java.util.*;


class Animal {
    public void speak() {
        System.out.println("Animal sound");
    }
}


class Dog extends Animal {
    public void speak() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    public void speak() {
        System.out.println("Cat meows");
    }
}

class Main {

   
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal a : animals) {
            a.speak();
        }
    }

    public static void main(String[] args) {

        List<Dog> dogs = Arrays.asList(new Dog(), new Dog());
        List<Cat> cats = Arrays.asList(new Cat(), new Cat());

        printAnimals(dogs);
        printAnimals(cats);
    }
}