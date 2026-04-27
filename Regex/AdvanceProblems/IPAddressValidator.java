package com.gla.Regex.AdvanceProblems;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPAddressValidator {
    private static final String IPV4_REGEX =
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}"
                    + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public static boolean isValidIPv4(String ip) {
        if (ip == null) return false;
        Pattern pattern = Pattern.compile(IPV4_REGEX);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] tests = {
                "192.168.1.1",
                "255.255.255.255",
                "0.0.0.0",
                "256.1.1.1",
                "123.456.78.90",
                "192.168.1",
                "abc.def.ghi.jkl"
        };

        for (String ip : tests) {
            System.out.println(ip + " -> " + (isValidIPv4(ip) ? "Valid" : "Invalid"));
        }
    }
}




