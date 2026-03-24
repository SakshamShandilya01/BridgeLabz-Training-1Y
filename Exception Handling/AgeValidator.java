import java.util.Scanner;


class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {


    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            // Step 3: Call validation method
            validateAge(age);

            // If no exception
            System.out.println("Access granted!");
        } 
        catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } 
        catch (Exception e) {
            System.out.println("Invalid input!");
        }

        sc.close();
    }
}