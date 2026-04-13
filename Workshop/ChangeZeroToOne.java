import java.util.Scanner;

public class ChangeZeroToOne {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int newNum = 0;
        int place = 1;

        while(num > 0) {
            int digit = num % 10;

            if(digit == 0) {
                digit = 1;
            }

            newNum = newNum + digit * place;

            place = place * 10;
            num = num / 10;
        }

        System.out.println("Number after changing 0 to 1: " + newNum);
    }
}