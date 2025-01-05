package collections;

import java.util.*;

public class StudentMarks implements Comparable<StudentMarks>{
    private int maths;
    private int physics;

    public  StudentMarks(int maths,int physics){
        this.maths=maths;
        this.physics=physics;
    }
    public int getMaths() {
        return maths;
    }

    public int getPhysics() {
        return physics;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentMarks that = (StudentMarks) o;

        if (maths != that.maths) return false;
        return physics == that.physics;
    }

    @Override
    public int hashCode() {
        int result = maths;
        result = 31 * result + physics;
        return result;
    }


    @Override
    public String toString() {
        return "StudentMarks{" +
                "maths=" + maths +
                ", physics=" + physics +
                '}';
    }

    @Override
    public int compareTo(StudentMarks o) {
//        if(this.maths < o.maths)
//            return -1;
//        if(this.maths > o.maths)
//            return 1;
//        if(this.maths == o.maths)
//            return 0;
//        return 0;
        return -this.maths + o.maths;
        
    }

}
class PriorityQueuesTest{
    public static void main(String[] args) {
        //get me top 3 students according to their maths marks
        List<StudentMarks> smarks=new ArrayList<>();
        smarks.add(new StudentMarks(70,80));
        smarks.add(new StudentMarks(38,10));
        smarks.add(new StudentMarks(100,38));
        smarks.add(new StudentMarks(40,88));
        smarks.add(new StudentMarks(97,19));
        smarks.add(new StudentMarks(65,45));

        PriorityQueue<StudentMarks> pq=new PriorityQueue<>((s1,s2)-> s2.getPhysics()-s1.getPhysics());
        for(StudentMarks sm: smarks){
            pq.add(sm);
        }
        List<StudentMarks> top3=new ArrayList<>();
        int ind=0;
        while(!pq.isEmpty()){
            if(ind==3)
                break;
            top3.add(pq.poll());
            ind++;
        }
        System.out.println(top3);


    }
    class MyCustomComparator implements Comparator<StudentMarks>{

        @Override
        public int compare(StudentMarks o1, StudentMarks o2) {
            return o1.getMaths()-o2.getMaths();
        }
    }
}
