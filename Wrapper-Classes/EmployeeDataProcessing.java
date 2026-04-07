package com.gla.WrapperClasses.level1;
import java.util.ArrayList;
import java.util.Collections;
public class EmployeeDataProcessing {
    public static void main(String[] args) {

        // Given primitive array
        int[] ages = {22, 35, 18, 40, 29};

        // Convert int[] → ArrayList<Integer> (auto-boxing)
        ArrayList<Integer> ageList = new ArrayList<>();
        for (int age : ages) {
            ageList.add(age); // auto-boxing
        }

        // Find youngest and oldest
        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

        // Print results
        System.out.println("Ages List: " + ageList);
        System.out.println("Youngest age = " + youngest);
        System.out.println("Oldest age = " + oldest);
    }
}
