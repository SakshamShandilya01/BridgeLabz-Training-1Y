package com.gla.Regex.BasicProblems;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DateExtractor {
    private static final String DATE_REGEX = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        Pattern pattern = Pattern.compile(DATE_REGEX);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Found dates:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
