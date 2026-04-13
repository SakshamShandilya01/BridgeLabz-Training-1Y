import java.util.*;

class CopyElements {

  
    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        for (Number n : src) {
            dest.add(n);
        }
    }

    public static void main(String[] args) {

        List<Integer> src = Arrays.asList(1, 2, 3);
        List<Number> dest = new ArrayList<>();

        copyList(dest, src);

        System.out.println(dest);
    }
}