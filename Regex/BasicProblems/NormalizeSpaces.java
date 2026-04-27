package com.gla.Regex.BasicProblems;

public class NormalizeSpaces {
    public static void main(String[] args) {
        String input = "This  is   an   example    with   multiple   spaces.";

        String output = input.replaceAll("\\s+", " ");

        System.out.println(output);
    }
}
