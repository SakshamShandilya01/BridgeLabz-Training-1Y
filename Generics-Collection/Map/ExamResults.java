
import java.util.*;
public class ExamResults {
    public static void main(String[] args) {
        Map<String, Map<String,Integer>> map = new HashMap<>();
        Map<String,Integer> math = new HashMap<>();
        math.put("A",90);
        math.put("B",80);
        map.put("Math", math);
        for(var sub: map.entrySet()){
            int max=0; String top="";
            for(var e: sub.getValue().entrySet()){
                if(e.getValue()>max){ max=e.getValue(); top=e.getKey(); }
            }
            System.out.println(sub.getKey()+" Topper: "+top);
        }
    }
}
