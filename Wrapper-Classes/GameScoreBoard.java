package com.gla.WrapperClasses.level1;

public class GameScoreBoard {
    public static void main(String[] args) {

        // Given Integer array (some players haven't played → null)
        Integer[] scores = {50, null, 80, 30, null, 100};

        int notPlayedCount = 0;
        int totalScore = 0;

        for (Integer score : scores) {
            if (score == null) {
                notPlayedCount++; // count players who haven't played
            } else {
                totalScore += score; // auto-unboxing (Integer → int)
            }
        }

        // Output
        System.out.println("Players not played = " + notPlayedCount);
        System.out.println("Total score of valid players = " + totalScore);
    }
}
