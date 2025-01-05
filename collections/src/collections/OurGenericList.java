package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class OurGenericList<T> implements Iterable<T>  {
    public T[] items;
    private int size;
    public OurGenericList(){
        size=0;
        items=(T[])new Object[100];
    }
    public void add(T item){
        items[size++]=item;
    }
    public T getItemAtIndex(int index){
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new OurGenericListIterator(this);
    }
    private class OurGenericListIterator implements Iterator<T>{
        private OurGenericList<T> list;
        private int index=0;
        public OurGenericListIterator(OurGenericList<T> list){
            this.list=list;
        }

        @Override
        public boolean hasNext() {
            return index<list.size;
        }

        @Override
        public T next() {
           return list.items[index++];
        }
    }
}
class CollectionsTest{
    public static void main(String[] args) {
        OurGenericList<Integer> list=new OurGenericList<>();
        list.add(1);
        list.add(2);
        list.add(3);



    Iterator<Integer> itr=list.iterator();
    while(itr.hasNext()){
        System.out.println(itr.next());
    }

       for(int i:list){
           System.out.println(i);
       }
    }


}
