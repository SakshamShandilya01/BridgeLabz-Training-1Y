package com.gla.StreamAPI;
import java.util.*;

public class PatientIDPrinting {
    public static void printID(String id) {
        System.out.println(id);
    }

    public static void main(String[] args) {
        List<String> ids = Arrays.asList("P101", "P102", "P103");
        ids.forEach(PatientIDPrinting::printID);
    }
}