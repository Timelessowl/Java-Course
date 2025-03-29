package lr3;

import java.util.HashMap;
import java.util.Map;

public class hashmap {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven7");
        map.put(8, "Eight8");
        map.put(9, "Nine");

        System.out.println("Строки с ключем > 5:");
        for (var entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println("Ключ " + entry.getKey() + " -> " + entry.getValue());
            }
        }
        System.out.println("-------------------------------------------");
        if (map.containsKey(0)) {
            for (var entry : map.entrySet()) {
                System.out.println("Ключ " + entry.getKey() + " -> " + entry.getValue());
            }
        }

        System.out.println("-------------------------------------------");
        int result = 1;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                result *= entry.getKey();
            }
        }
        System.out.println("\nПроизведение ключей, где длина строки > 5: " + result);
    }
}
