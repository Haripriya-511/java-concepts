package parallelalgorithms;

import java.util.Random;

public class ParallelSumProblem{
    private ParallelSum[] workers;
    private int numOfThreads;
    public ParallelSumProblem(int numOfThreads)
    {
        this.numOfThreads=numOfThreads;
        this.workers=new ParallelSum[numOfThreads];
    }
    public int sum(int []nums){
        int size=(int) Math.ceil(nums.length*1.0/numOfThreads);
        for(int i=0;i<numOfThreads;i++){
        workers[i]=new ParallelSum(nums,i*size,(i+1)*size);
        workers[i].start();
        }
        try{
        for(ParallelSum worker:workers){
            worker.join();
        }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        int total=0;
        for(ParallelSum worker:workers){
            total+=worker.getPartialSum();
        }
        return total;
    }
}
 class ParallelSum extends Thread{
    private int[] nums;
    private int low;
    private int high;
    private int partialSum;
    public ParallelSum(int []nums,int low,int high){
        this.nums=nums;
        this.low=low;
        this.high=Math.min(nums.length,high);
    }
    @Override
    public void run() {
        partialSum=0;
        for(int i=low;i<high;i++){
            partialSum+=nums[i];
        }

    }
    public int getPartialSum(){
        return partialSum;
    }
}
class Application{
    public static void main(String[] args) {
        Random random=new Random();
        int[] nums=new int[1000000000];
        for(int i=0;i<1000000;i++){
            nums[i]=random.nextInt(100);
        }
        int n=Runtime.getRuntime().availableProcessors();
        //parallel algorithm
        ParallelSumProblem sumProblem=new ParallelSumProblem(n);
        long starttime=System.currentTimeMillis();
        System.out.println("Parallel sum:"+sumProblem.sum(nums));
        long endtime=System.currentTimeMillis();
        System.out.printf("Parallel sum time taken: %6d s\n",endtime-starttime);

        SequentialSumProblem sumProblem1=new SequentialSumProblem();
        starttime=System.currentTimeMillis();
        System.out.println("Sequential sum:"+sumProblem1.sum(nums));
        endtime=System.currentTimeMillis();
        System.out.printf("sequential sum time taken: %6d s\n",endtime-starttime);

    }
}
