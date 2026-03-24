import java.util.Scanner;

public class Arrayoperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter size of array: ");
            int size = sc.nextInt();

            int[] arr = new int[size];


            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.print("Enter index: ");
            int index = sc.nextInt();


            System.out.println("Value at index " + index + ": " + arr[index]);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } 
        catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } 
        catch (Exception e) {
            System.out.println("Invalid input!");
        }

        sc.close();
    }
}