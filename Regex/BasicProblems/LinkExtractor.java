package com.gla.Regex.BasicProblems;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkExtractor {
    private static final String URL_REGEX =
            "https?://[A-Za-z0-9.-]+\\.[A-Za-z]{2,}[/\\w\\-._~:?#[\\]@!$&'()*+,;=%]*";

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        Pattern pattern = Pattern.compile(URL_REGEX);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Found links:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
