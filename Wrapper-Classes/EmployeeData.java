package com.gla.WrapperClasses.level1;
import java.util.ArrayList;
import java.util.Collections;
public class EmployeeData {
    public static void main(String[] args) {

        // Given primitive int array (employee ages)
        int[] ages = {25, 32, 19, 45, 28};

        // Convert int[] to ArrayList<Integer> (auto-boxing)
        ArrayList<Integer> ageList = new ArrayList<>();
        for (int age : ages) {
            ageList.add(age); // auto-boxing (int → Integer)
        }

        // Finding youngest and oldest using Collections
        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

        // Printing results
        System.out.println("Employee Ages: " + ageList);
        System.out.println("Youngest age = " + youngest);
        System.out.println("Oldest age = " + oldest);
    }
}
