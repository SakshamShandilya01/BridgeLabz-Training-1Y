package com.gla.Regex.AdvanceProblems;
import java.util.regex.Pattern;
public class SSNValidator {
    private static final String SSN_REGEX = "^\\d{3}-\\d{2}-\\d{4}$";

    public static boolean isValidSSN(String ssn) {
        return ssn != null && Pattern.matches(SSN_REGEX, ssn);
    }

    public static void main(String[] args) {
        String[] tests = {
                "123-45-6789",
                "123456789",
                "12-345-6789",
                "000-00-0000"
        };
        for (String t : tests) {
            System.out.println(t + " -> " + (isValidSSN(t) ? "Valid" : "Invalid"));
        }
    }
}
