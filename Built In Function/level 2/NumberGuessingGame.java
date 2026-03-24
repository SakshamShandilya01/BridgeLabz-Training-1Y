package com.gla.ExtrasBuiltinFunction.level2;
import java.util.Scanner;
public class NumberGuessingGame {
    static int generateGuess(int low, int high) {
        return (low + high) / 2;
    }

    static String getFeedback(Scanner sc, int guess) {
        System.out.println("Computer guesses: " + guess);
        System.out.print("Enter feedback (high/low/correct): ");
        return sc.nextLine().toLowerCase();
    }

    static void playGame() {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        String feedback;

        while (true) {
            int guess = generateGuess(low, high);
            feedback = getFeedback(sc, guess);

            if (feedback.equals("correct")) {
                System.out.println("Computer guessed correctly!");
                break;
            }
            else if (feedback.equals("high")) {
                high = guess - 1;
            }
            else if (feedback.equals("low")) {
                low = guess + 1;
            }
        }

        sc.close();
    }

    public static void main(String[] args) {
        playGame();
    }
}
