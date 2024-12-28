package designpatterns.creational.structural;

interface FifoColletion<T>{
    T poll();
    void offer(T element);

}
class Queue<T> implements FifoColletion<T>{
    private LinkedList<T> linkedList;
    public Queue(LinkedList<T> linkedList) {
        this.linkedList = linkedList; // Inject the implementation of LinkedList
    }

    @Override
    public T poll() {
        return linkedList.removeFirst();
    }

    @Override
    public void offer(T element) {
 linkedList.addLast(element);
    }
}
interface LinkedList<T>{
    void addFirst(T ele);
    void addLast(T ele);
    T removeFirst();
    T removeLast();
}
class SinglyLinkedList<T> implements LinkedList<T>{

    private class Node{
        private Object data;
        private Node next;
        private Node(Object data,Node next){
            this.next=next;
            this.data=data;
        }
    }
    private int size;
    private Node top;
    private Node last;

    @Override
    public void addFirst(T ele) {
        if(top==null)
            last=top=new Node(ele,null);
        else
            top=new Node(ele,top);
        size++;
    }

    @Override
    public void addLast(T ele) {
        if(top==null)
            last=top=new Node(ele,null);
        else {
            last.next=new Node(ele,null);
            last=last.next;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if(top==null)
        return null;
        T data= (T) top.data;
        top=top.next;
        if(top==null)
            last=null;

        return  data;
    }

    @Override
    public T removeLast() {
        if(top==null)
            return null;
        if(top==last) {
            T data = (T) top.data;
            top = last = null;
            size--;
            return data;
        }
        Node current = top;
        while (current.next != last) {
            current = current.next;
        }
        T data = (T) last.data;
        last = current;
        last.next = null;
        size--;
        return data;

    }
}
public class BridgeDesignPattern {
    public static void main(String[] args) {
       FifoColletion<Integer> colletion=new Queue<>(new SinglyLinkedList<>());
       colletion.offer(10);
       colletion.offer(25);
       colletion.offer(96);
        System.out.println(colletion.poll());
        System.out.println(colletion.poll());
        System.out.println(colletion.poll());
        System.out.println(colletion.poll());
    }
}
