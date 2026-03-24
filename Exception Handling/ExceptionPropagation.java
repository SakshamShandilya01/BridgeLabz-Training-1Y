public class ExceptionPropagation {


    static void method1() {
        int result = 10 / 0;   // ArithmeticException
    }


    static void method2() {
        method1();   // exception goes to main
    }

    public static void main(String[] args) {

        try {
            method2();   // calling method2
        } 
        catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }

        System.out.println("Program continues...");
    }
}