package com.gla.Regex.AdvanceProblems;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanguageExtractor {
    private static final String LANG_REGEX = "\\b(Java|Python|JavaScript|Go)\\b";

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        Pattern pattern = Pattern.compile(LANG_REGEX);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Programming languages found:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
