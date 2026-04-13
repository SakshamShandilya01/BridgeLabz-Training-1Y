
class GenericBox<T> {
    private T value;

    
    public void set(T value) {
        this.value = value;
    }

   
    public T get() {
        return value;
    }
}


public class Main {
    public static void main(String[] args) {

       
        Box<Integer> intBox = new Box<>();
        intBox.set(10);
        System.out.println("Integer: " + intBox.get());

     
        Box<String> strBox = new Box<>();
        strBox.set("Hello");
        System.out.println("String: " + strBox.get());

        /
        Box<Double> dblBox = new Box<>();
        dblBox.set(5.5);
        System.out.println("Double: " + dblBox.get());
    }
}