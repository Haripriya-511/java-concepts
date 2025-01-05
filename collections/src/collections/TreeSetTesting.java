package collections;

import java.util.*;

public class TreeSetTesting {
    public static void main(String[] args) {

        Set<StudentMarks> tree=new TreeSet<>((s1,s2)-> s2.getPhysics()- s1.getPhysics());
        tree.add(new StudentMarks(70,80));
        tree.add(new StudentMarks(38,10));
        tree.add(new StudentMarks(100,38));
        tree.add(new StudentMarks(40,88));
        tree.add(new StudentMarks(97,19));
        tree.add(new StudentMarks(65,45));
       for(StudentMarks x: tree){
           System.out.println(x+" ,");
       }
        System.out.println("********");
       NavigableSet<Integer> set=new TreeSet<>();
       set.add(10);
       set.add(20);
       set.add(30);
       set.add(40);
       set.add(50);

       for(int x: set){
           System.out.print(x+" , ");
       }
        System.out.println();
       //ceiling
        System.out.println(set.floor(25));//30
        System.out.println(set.ceiling(40));//40
        //higher
        System.out.println(set.higher(25));
        System.out.println(set.higher(40));
        System.out.println(set.higher(50));
        //floor
        System.out.println(set.floor(25));
        System.out.println(set.floor(40));
        //lower
        System.out.println(set.lower(25));
        System.out.println(set.lower(40));
        System.out.println(set.lower(10));
    }
}
