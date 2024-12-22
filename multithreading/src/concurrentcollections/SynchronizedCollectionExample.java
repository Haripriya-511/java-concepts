package concurrentcollections;

import java.util.*;

public class SynchronizedCollectionExample {
    public static void main(String[] args) {
        Collection<Integer> syncCollection= Collections.synchronizedCollection(new ArrayList<>());
       // List<Integer> syncList= Collections.synchronizedList(new ArrayList<>());
       // Map<Integer,String> syncMap=Collections.synchronizedMap(new HashMap<>());
        // Set<Integer> syncSet = Collections.synchronizedSet(new HashSet<>());
      //  SortedSet<Integer> syncSortedSet = Collections.synchronizedSortedSet(new TreeSet<>());


        List<Integer> list=new ArrayList<>();
        Runnable listOp=()->{
            for(int i=0;i<1000;i++) {
                list.add(i);
                syncCollection.add(i);
            }
        };
        Thread t1=new Thread(listOp);
        Thread t2=new Thread(listOp);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        System.out.println("Synchronized list size:"+syncCollection.size());
        System.out.println("Normal list size:"+list.size());

    }
}
