package collections;

import java.util.*;

public class SetTesting {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);list.add(2);list.add(3);
        Set<Integer> set1=new HashSet<>(list);
        Set<Integer> set2=new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set1.add(null);


        System.out.println(set1);// 1 2 3
        System.out.println(set2);// 2 3 4
        System.out.println("After retaining...");
        set1.retainAll(set2);
        System.out.println(set1);// 2 3
        System.out.println(set2);// 2 3 4
        // if we do removeAll()
        //then set1-> 1
        //     set2-> 2 3 4

        List<StudentMarks> smarks=new ArrayList<>();
        smarks.add(new StudentMarks(70,80));
        smarks.add(new StudentMarks(38,10));
        smarks.add(new StudentMarks(100,38));
        smarks.add(new StudentMarks(40,88));
        smarks.add(new StudentMarks(97,19));
        smarks.add(new StudentMarks(65,45));
        Set<StudentMarks> st=new HashSet<>(smarks);
        System.out.println(st.contains(new StudentMarks(70,80)));



    }
}
