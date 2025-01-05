package collections;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("riddhi",1);
        map.put("raj",2);
        map.put("chandler",7);
        System.out.println(map.getOrDefault(25,0));
        System.out.println(map.containsKey("riddhi"));

        //////////////////
        Map<Integer, List<Integer>> adj=new HashMap<>();
        // 1->2
        // 3->5
        // 1->3
        if(adj.get(1)==null)
            adj.put(1,new ArrayList<>());
        adj.get(1).add(2);

        adj.computeIfAbsent(1,f-> new ArrayList<>()).add(2);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String,Integer> entry: entries){
            System.out.println(entry.getKey()+" "+entry.getValue());

        }
       Set<String> keys= map.keySet();
        for(String key:keys){
            System.out.println(key);
        }
        Collection<Integer> values = map.values();

        Iterator<Map.Entry<String,Integer>> itr=map.entrySet().iterator();
        map.forEach((k,v)-> System.out.println(k+" "+v));

        Map<String, Integer> map1 = new HashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 10);
        map.put("Charlie", 20);

        System.out.println("*************");
        // Use TreeMap with a custom comparator
       }


    }

