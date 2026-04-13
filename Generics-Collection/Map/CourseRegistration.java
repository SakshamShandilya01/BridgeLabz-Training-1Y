
import java.util.*;
public class CourseRegistration {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("CS101",50);
        map.put("CS102",3);
        for(var e: map.entrySet()){
            if(e.getValue()>=50) System.out.println("Full: "+e.getKey());
            if(e.getValue()<5) System.out.println("Low: "+e.getKey());
        }
    }
}
