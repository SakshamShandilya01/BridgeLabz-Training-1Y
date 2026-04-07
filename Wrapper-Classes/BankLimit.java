package com.gla.WrapperClasses.level1;

public class BankLimit {
    public static double getRemainingLimit(Double limit) {

        // Handle null case
        if (limit == null) {
            return 0.0;
        }

        // Auto-unboxing (Double → double)
        return limit;
    }

    public static void main(String[] args) {

        // Test cases
        Double limit1 = 5000.0;
        Double limit2 = null;

        System.out.println("Remaining limit (limit1) = " + getRemainingLimit(limit1));
        System.out.println("Remaining limit (limit2) = " + getRemainingLimit(limit2));
    }
}
