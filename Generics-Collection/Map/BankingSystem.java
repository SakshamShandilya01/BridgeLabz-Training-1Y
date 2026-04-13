
import java.util.*;
public class BankingSystem {
    public static void main(String[] args) {
        Map<String,Double> map = new HashMap<>();
        map.put("101",1000.0);
        map.put("101", map.get("101")+500);
        if(map.get("101")>=200)
            map.put("101", map.get("101")-200);
        System.out.println(map);
    }
}
