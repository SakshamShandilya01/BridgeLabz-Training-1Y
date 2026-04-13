
import java.util.*;
public class EmployeeDepartment {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"HR");
        map.put(2,"IT");
        map.put(1,"Finance");
        for(var e: map.entrySet())
            if(e.getValue().equals("Finance"))
                System.out.println(e.getKey());
    }
}
