package com.gla.WrapperClasses.level1;
import java.util.Scanner;
public class CharacterCount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int letters = 0;
        int digits = 0;
        int special = 0;

        // Loop through each character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                letters++;
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (!Character.isWhitespace(ch)) {
                special++;
            }
        }

        // Printing results
        System.out.println("Total letters = " + letters);
        System.out.println("Total digits = " + digits);
        System.out.println("Total special characters = " + special);

        sc.close();
    }
}
