import java.util.*;

public class CollegeAdmission {
    public static void main(String[] args) {

        List<int[]> list = new ArrayList<>(); // {id, marks}
        Set<Integer> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        TreeSet<int[]> merit = new TreeSet<>((a,b)->b[1]-a[1]);

        // add students
        list.add(new int[]{1,85});
        list.add(new int[]{2,60});
        list.add(new int[]{3,90});

        // shortlist (marks > 70)
        for(int[] s : list)
            if(s[1] > 70 && set.add(s[0])) queue.add(s);

        // interview + final selection
        while(!queue.isEmpty())
            merit.add(queue.poll());

        // display merit list
        for(int[] s : merit)
            System.out.println("ID: " + s[0] + " Marks: " + s[1]);
    }
}