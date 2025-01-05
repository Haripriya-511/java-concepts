package collections;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTesting {
    public static void main(String[] args) {
        //lifo
        Deque<Integer> dq=new LinkedList<>();
        dq.offer(10);
        dq.offer(20);
        dq.offer(30);
        while(!dq.isEmpty()){
            System.out.println(dq.peek());
            System.out.println(dq.poll());
        }
        System.out.println("***********");



    }
}
