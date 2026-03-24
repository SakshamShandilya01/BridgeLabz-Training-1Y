import static java.lang.Math.*;

public class StaticImportDemo {

    public static void main(String[] args) {

        int a = 16;
        int b = 5;

        System.out.println(sqrt(a));
        System.out.println(pow(a,2));
        System.out.println(max(a,b));
        System.out.println(min(a,b));
        System.out.println(abs(-20));

    }
}