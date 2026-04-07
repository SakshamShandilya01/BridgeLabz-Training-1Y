package com.gla.WrapperClasses.level1;
import java.util.ArrayList;
public class PerformanceList {
    public static void main(String[] args) {

        int n = 1_000_000;

        // -------- int[] --------
        long startArray = System.currentTimeMillis();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        long sumArray = 0;
        for (int i = 0; i < n; i++) {
            sumArray += arr[i];
        }

        long endArray = System.currentTimeMillis();

        // -------- ArrayList<Integer> --------
        long startList = System.currentTimeMillis();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i); // auto-boxing
        }

        long sumList = 0;
        for (Integer val : list) {
            sumList += val; // auto-unboxing
        }

        long endList = System.currentTimeMillis();

        // -------- Results --------
        System.out.println("Array sum = " + sumArray);
        System.out.println("Array time = " + (endArray - startArray) + " ms");

        System.out.println("ArrayList sum = " + sumList);
        System.out.println("ArrayList time = " + (endList - startList) + " ms");
    }
}
