package collections;

import java.util.*;

public class ListTesting {
    public static void main(String[] args) {
        List<Integer> alist=new ArrayList<>();
        alist.add(1);
        alist.add(2);
        alist.add(3);
//        Integer ii=1;
//        alist.remove(ii);
//        System.out.println(alist); //[2,3]
        System.out.println("element that got replaced ="+alist.set(1,100));//2

        System.out.println("Alist1:"+alist);// 1 100 3

        List<Integer> alist2=new ArrayList<>(alist);
        System.out.println("Alist2:"+alist2);// 1 100 3

        alist2.addAll(alist);// 1 100 3 1 100 3
        System.out.println("Alist2:"+alist2);

        alist2.set(2,300);
        alist2.add(522);
        System.out.println(alist+" "+alist2);//[1 100 3] [1 100 300 1 100 3 522]
           List<List<Integer>> list=new ArrayList<>();
           list.add(alist);
           list.add(alist2);
           alist.set(0,1000);
            System.out.println(list);//[[1000, 100, 3], [1, 100, 300, 1, 100, 3, 522]]
            list.get(1).set(6,6000);
            System.out.println(alist2);//[1, 100, 300, 1, 100, 3, 6000]
        System.out.println("\n************************");
        List<Integer> lk=new LinkedList<>();
        lk.add(1);
        lk.add(2);
        lk.add(3);
        ListIterator<Integer> iterator=lk.listIterator();
        System.out.println(iterator.next());//1
        System.out.println(iterator.next());//2
        System.out.println(iterator.previous());//2
            int arr[]=lk.stream().mapToInt(Integer::intValue)
                    .toArray();
            Integer[] arr1=alist2.toArray(new Integer[10]);
            for(Integer i: arr1)
        System.out.print(i+" ");
    }
}
