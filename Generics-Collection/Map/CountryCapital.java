
import java.util.*;
public class CountryCapital {
    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<>();
        map.put("India","Delhi");
        map.put("USA","Washington");
        System.out.println(map.getOrDefault("India","Unknown"));
        System.out.println(map);
    }
}
