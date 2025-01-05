package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ArrayDequeTest {
    public static void main(String[] args) {
        //Lifo impl
        Deque<Integer> stack1=new ArrayDeque();
        stack1.offerLast(10);
        stack1.offerLast(20);
        stack1.offerLast(30);
       while (!stack1.isEmpty()){
           System.out.println(stack1.peekLast());
           System.out.println(stack1.pollLast());
       }
        System.out.println("*********");
        Deque<Integer> stack2=new ArrayDeque();
        stack2.offerFirst(10);
        stack2.offerFirst(20);
        stack2.offerFirst(30);
        while (!stack2.isEmpty()){
            System.out.println(stack2.peekFirst());
            System.out.println(stack2.pollFirst());
        }
        System.out.println("*********");
        Deque<Integer> stack3=new ArrayDeque();
        stack3.offerFirst(10);
        stack3.offerFirst(20);
        stack3.offerFirst(30);
        while (!stack3.isEmpty()){
            System.out.println(stack3.peek());
            System.out.println(stack3.pollFirst());
        }
        System.out.println("*****************************************");
        //FIFO IMPL
        Deque<Integer> q1=new LinkedList();
        q1.offerLast(10);
        q1.offerLast(20);
        q1.offerLast(30);
        while (!q1.isEmpty()){
            System.out.println(q1.peek());
            System.out.println(q1.pollFirst());
        }
        System.out.println("*********");
        Deque<Integer> q2=new LinkedList();
        q2.offerFirst(10);
        q2.offerFirst(20);
        q2.offerFirst(30);
        while (!q2.isEmpty()){
            System.out.println(q2.peekLast());
            System.out.println(q2.pollLast());
        }
        System.out.println("*********");
        Deque<Integer> q3=new LinkedList();
        q3.offerLast(10);
        q3.offerLast(20);
        q3.offerLast(30);
        while (!q3.isEmpty()){
            System.out.println(q3.peekFirst());
            System.out.println(q3.pollFirst());
        }
        System.out.println("*********");
        Deque<Integer> q4=new LinkedList();
        q4.push(20);
        q4.push(40);
        q4.push(60);

        while (!q4.isEmpty()){
            System.out.println(q4.peek());
            System.out.println(q4.pop());
        }


    }
}
