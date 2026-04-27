package com.gla.Regex.AdvanceProblems;
import java.util.regex.Pattern;
public class CreditCardValidator {
    private static final String VISA_REGEX        = "^4[0-9]{15}$";
    private static final String MASTERCARD_REGEX  = "^5[0-9]{15}$";
    private static final String VISA_OR_MC_REGEX  = "^(4[0-9]{15}|5[0-9]{15})$";

    public static boolean isValidVisa(String number) {
        return Pattern.matches(VISA_REGEX, number);
    }

    public static boolean isValidMasterCard(String number) {
        return Pattern.matches(MASTERCARD_REGEX, number);
    }

    public static boolean isValidVisaOrMasterCard(String number) {
        return Pattern.matches(VISA_OR_MC_REGEX, number);
    }

    public static void main(String[] args) {
        String[] tests = {
                "4123456789012345",
                "5123456789012345",
                "6123456789012345",
                "412345678901234",
                "51234567890123456"
        };

        for (String n : tests) {
            System.out.println(n + " -> VisaOrMC: " +
                    (isValidVisaOrMasterCard(n) ? "Valid" : "Invalid"));
        }
    }
}
