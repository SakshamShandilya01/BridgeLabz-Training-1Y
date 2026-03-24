import java.util.*;

class ArrayDivisionHandler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {10, 20, 30};

        try {
            int i = sc.nextInt();   // index
            int d = sc.nextInt();   // divisor

            try {
                System.out.println(arr[i] / d);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}