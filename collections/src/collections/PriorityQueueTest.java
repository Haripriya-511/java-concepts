package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
      //  PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pq=new PriorityQueue<>(new MyCustomComparator());

        pq.offer(1);
        pq.offer(2);
        pq.offer(0);
        pq.offer(100);
        //top 2 elements
        List<Integer> top2=new ArrayList<>();
        int ind=0;
        while(!pq.isEmpty()){
            if(ind==2)
                break;
            top2.add(pq.poll());
            ind++;
        }
        System.out.println(top2);
        System.out.println(pq);
    }

    }
class MyCustomComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
