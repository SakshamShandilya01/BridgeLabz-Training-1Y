
import java.util.*;
public class InventoryManagement {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 5);
        map.put("Apple", map.get("Apple") - 10);
        map.put("Banana", map.get("Banana") + 5);
        for (var e : map.entrySet())
            if (e.getValue() <= 0)
                System.out.println(e.getKey() + " out of stock");
    }
}
