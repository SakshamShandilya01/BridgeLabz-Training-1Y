package com.gla.Regex.BasicProblems;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedWordsExtractor {
    private static final String CAPITALIZED_WORD_REGEX = "\\b[A-Z][a-zA-Z]*\\b";

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        Pattern pattern = Pattern.compile(CAPITALIZED_WORD_REGEX);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Capitalized words:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
