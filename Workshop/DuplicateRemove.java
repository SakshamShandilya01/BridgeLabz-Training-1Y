import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateRemove {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }


        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {

                if(list.get(i).equals(list.get(j))) {
                    list.remove(j);
                    j = j - 1;
                }
            }
        }

        System.out.println("List after removing duplicates: " + list);
    }
}