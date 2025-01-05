package collections;

import java.util.*;

public class QueueTesting {
    public static void main(String[] args) {
     Queue<Integer> queue=new LinkedList<>();
     queue.offer(1);
     queue.offer(2);
     queue.offer(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        System.out.println("***********");
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        while (!st.isEmpty()){
            System.out.println(st.peek());
            System.out.println(st.pop());
        }
        System.out.println("***********");
        //Array Deque -lifo
        Deque<Integer> dq=new ArrayDeque<>();
        dq.offerLast(12);
        dq.offerLast(15);
        System.out.println(dq.peekLast());
        System.out.println(dq.pollLast());
        System.out.println(dq.pollLast());





    }
}
