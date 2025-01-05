package collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

public class ArrangeByValues {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 10);
        map.put("Charlie", 20);

        // Use TreeMap with a custom comparator
        TreeMap<String, Integer> sortedMap = new TreeMap<>((key1, key2) -> {
            int compare = map.get(key1).compareTo(map.get(key2));
            if (compare == 0) return key1.compareTo(key2); // Break ties using keys
            return compare;
        });
        ArrayList l;
        
        sortedMap.putAll(map);
        CopyOnWriteArrayList c;
        CopyOnWriteArraySet ss;
        ConcurrentHashMap manp;

        // Print the sorted map
        sortedMap.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}
