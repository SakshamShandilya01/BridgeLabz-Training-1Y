package com.bank.main;

import com.bank.util.InterestCalculator;
import static java.lang.Math.*;

public class MainApp {

    public static void main(String[] args) {

        double p = 10000;
        double r = 5;
        double t = 2;

        InterestCalculator ic = new InterestCalculator();

        double si = ic.calculateSimpleInterest(p, r, t);

        // compound interest using static import pow()
        double ci = p * pow((1 + r / 100.0), t) - p;

        System.out.println("Simple Interest: " + si);
        System.out.println("Compound Interest: " + ci);
    }
}