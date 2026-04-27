package com.gla.Regex.BasicProblems;
import java.util.regex.Pattern;
public class HexColorValidator {
    private static final String HEX_COLOR_REGEX = "^#[0-9A-Fa-f]{6}$";

    public static boolean isValidHexColor(String color) {
        return Pattern.matches(HEX_COLOR_REGEX, color);
    }
    public static void main(String[] args) {
        String[] testColors = {
                "#FFFFFF",
                "#000000",
                "#1A2b3F",
                "#FFF",
                "FFFFFF",
                "#ZZZZZZ"
        };
        for (String c : testColors) {
            System.out.println(c + " -> " + (isValidHexColor(c) ? "Valid" : "Invalid"));
        }
    }
}
