import java.util.*;

class Sum {

       public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;

        for (Number n : list) {
            sum += n.doubleValue();
        }

        return sum;
    }

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(10, 20, 30);
        List<Double> dblList = Arrays.asList(1.5, 2.5, 3.0);

        System.out.println("Integer Sum: " + sumNumbers(intList));
        System.out.println("Double Sum: " + sumNumbers(dblList));
    }
}