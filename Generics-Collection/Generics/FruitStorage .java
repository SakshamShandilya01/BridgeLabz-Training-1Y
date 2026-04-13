
class FruitStorage {
    String name;

    Fruit(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}


class Apple extends Fruit {
    Apple() {
        super("Apple");
    }
}

class Mango extends Fruit {
    Mango() {
        super("Mango");
    }
}


class FruitBox<T extends Fruit> {
    private T fruit;

    public void add(T fruit) {
        this.fruit = fruit;
    }

    public void display() {
        System.out.println("Fruit: " + fruit);
    }
}


class Car {}

public class Main {
    public static void main(String[] args) {

        FruitBox<Apple> box1 = new FruitBox<>();
        box1.add(new Apple());
        box1.display();

        FruitBox<Mango> box2 = new FruitBox<>();
        box2.add(new Mango());
        box2.display();

       
    }
}