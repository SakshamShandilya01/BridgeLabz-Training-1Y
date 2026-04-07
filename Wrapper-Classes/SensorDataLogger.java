package com.gla.WrapperClasses.level1;
import java.util.ArrayList;
public class SensorDataLogger {
    public static void logTemperature(Double temp, ArrayList<Double> list) {
        if (temp == null) {
            System.out.println("Null value received, skipping...");
            return;
        }

        list.add(temp); // auto-boxing if primitive passed
    }

    public static void main(String[] args) {

        ArrayList<Double> temperatureList = new ArrayList<>();

        // Primitive input (auto-boxing happens)
        double t1 = 25.5;
        logTemperature(t1, temperatureList);

        // Wrapper input
        Double t2 = 30.2;
        logTemperature(t2, temperatureList);

        // Null value
        Double t3 = null;
        logTemperature(t3, temperatureList);

        // Reading values (auto-unboxing happens)
        double sum = 0;
        for (Double temp : temperatureList) {
            sum += temp; // auto-unboxing (Double → double)
        }

        double average = sum / temperatureList.size();

        // Output
        System.out.println("Stored temperatures: " + temperatureList);
        System.out.println("Average temperature = " + average);
    }
}
