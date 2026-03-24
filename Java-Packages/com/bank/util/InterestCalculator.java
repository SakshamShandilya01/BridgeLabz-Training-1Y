package com.bank.util;

public class InterestCalculator {

    public double calculateSimpleInterest(double p, double r, double t) {
        return (p * r * t) / 100.0;
    }

    public double calculateCompoundInterest(double p, double r, double t) {
        // Formula: CI = P * (1 + R/100)^T - P
        return p * Math.pow((1 + r / 100.0), t) - p;
    }
}
