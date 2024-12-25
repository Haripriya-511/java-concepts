package forkjoinframework;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import java.util.concurrent.ForkJoinPool;
class SequentialMaxFinding{
    public long max(long[] nums){
    long max= nums[0];
    for(int i=1;i<nums.length;i++){
        max=Math.max(max,nums[i]);
    }
    return max;
    }

}
class ParallelMaxTask extends RecursiveTask<Long>{
private long[] nums;
private int lowIndex;
private int highIndex;
public ParallelMaxTask(long[] nums,int lowIndex,int highIndex){
    this.nums=nums;
    this.lowIndex=lowIndex;
    this.highIndex=highIndex;
}

    @Override
    protected Long compute() {
    if(highIndex-lowIndex<5000){
        return sequentialMaxFinding();
    }else {
        //parallelisation
        int middleIndex = (highIndex + lowIndex) / 2;
        ParallelMaxTask task1 = new ParallelMaxTask(nums, lowIndex, middleIndex);
        ParallelMaxTask task2 = new ParallelMaxTask(nums, middleIndex + 1, highIndex);
        invokeAll(task1, task2);
        return Math.max(task1.join(), task2.join());
    }
    }

    private Long sequentialMaxFinding() {
    long max=nums[lowIndex];
    for(int i=lowIndex+1;i<highIndex;i++){
        max=Math.max(max,nums[i]);
    }
    return max;
    }
}
public class MaximumFindingProblem {
    //linear search O(N)
    public static void main(String[] args) {
long nums[]=createArray(500000000);
        ForkJoinPool pool=new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        SequentialMaxFinding sequential=new SequentialMaxFinding();
        long start= System.currentTimeMillis();
        System.out.println("Max:"+sequential.max(nums));
        long end=System.currentTimeMillis();
        System.out.println("Sequential max time:"+(end-start));


        ParallelMaxTask parallelMaxTask=new ParallelMaxTask(nums,0,nums.length-1);
         start= System.currentTimeMillis();
        System.out.println("Max:"+pool.invoke(parallelMaxTask));
         end=System.currentTimeMillis();
        System.out.println("Parallel max time:"+(end-start));

    }
    public static  long[] createArray(int n){
        Random random=new Random();
        long[] nums=new long[n];
        for(int i=0;i<n;i++){
            nums[i]=random.nextInt(1000);
        }

    return nums;

    }

}
