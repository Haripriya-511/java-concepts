package forkjoinframework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class PrintAction extends RecursiveAction{
List<Integer> nums;
public PrintAction(List<Integer> nums){
    this.nums=nums;
}
    @Override
    protected void compute() {
        if(nums.size()<2){
            System.out.println("The list size is small...");
            for(Integer num:nums)
                System.out.println(num);
        }
        else{
            System.out.println("Splitting into tasks");
            List<Integer> left=nums.subList(0,nums.size()/2);
            List<Integer> right=nums.subList(nums.size()/2,nums.size());
            PrintAction action1=new PrintAction(left);
            PrintAction action2=new PrintAction(right);
            invokeAll(action2,action1);
        }
    }
}
public class PrintIntegersRecuriveAction {
    public static void main(String[] args) {
        ForkJoinPool pool=new ForkJoinPool();
        PrintAction action=new PrintAction(Arrays.asList(1,2,3,4,5,6,7,8));
        pool.invoke(action);

    }
}
