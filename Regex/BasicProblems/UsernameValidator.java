package com.gla.Regex.BasicProblems;
import java.util.regex.Pattern;
public class UsernameValidator {
    private static final String USERNAME_REGEX = "^[A-Za-z][A-Za-z0-9_]{4,14}$";

    public static boolean isValidUsername(String username) {
        return Pattern.matches(USERNAME_REGEX, username);
    }

    public static void main(String[] args) {
        String[] testUsernames = {
                "user_123",
                "123user",
                "us",
                "UserTest",
                "user__test_12345",
                "user-123"
        };

        for (String u : testUsernames) {
            System.out.println(u + " -> " + (isValidUsername(u) ? "Valid" : "Invalid"));
        }
    }
}
