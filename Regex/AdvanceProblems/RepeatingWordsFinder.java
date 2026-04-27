package com.gla.Regex.AdvanceProblems;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RepeatingWordsFinder {
    private static final String REPEATED_WORD_REGEX = "\\b(\\w+)\\b\\s+\\1\\b";

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        Pattern pattern = Pattern.compile(REPEATED_WORD_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        Set<String> repeatedWords = new LinkedHashSet<>();

        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));
        }
        System.out.println("Repeated words:");
        repeatedWords.forEach(System.out::println);
    }
}
