package com.gla.Regex.BasicProblems;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";

        List<String> badWords = Arrays.asList("damn", "stupid");
        String joined = String.join("|", badWords);
        String regex = "\\b(" + joined + ")\\b";

        String censored = input.replaceAll(regex, "****");

        System.out.println(censored);
    }
}
