
import java.util.*;
public class AttendanceTracker {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        String[] students = {"A","B","C","D","E"};
        for(String s: students) map.put(s,0);
        String[][] days = {{"A","B"},{"A","C"},{"A","D"},{"B","C"}};
        for(String[] day: days)
            for(String s: day)
                map.put(s, map.get(s)+1);
        for(var e: map.entrySet())
            if(e.getValue()<2)
                System.out.println(e.getKey());
    }
}
