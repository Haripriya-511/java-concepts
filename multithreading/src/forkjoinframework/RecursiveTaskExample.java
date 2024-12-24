package forkjoinframework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SimpleRecursiveTask extends RecursiveTask<Double>{
    private double num;
    public SimpleRecursiveTask(double num){
        this.num=num;
    }

    @Override
    protected Double compute() {
        if(num>100){
            System.out.println("Parallel execution..."+num);
            SimpleRecursiveTask task1=new SimpleRecursiveTask(num/2);
            SimpleRecursiveTask task2=new SimpleRecursiveTask(num/2);
            task1.fork();
            task2.fork();
            double subSolution=0;
            subSolution+=task1.join();
            subSolution+=task2.join();
            return subSolution;


        }else{
            //problem is small
            return 2*num;
        }

    }
}
public class RecursiveTaskExample {
    public static void main(String[] args) {
        ForkJoinPool pool=new ForkJoinPool();
        SimpleRecursiveTask task=new SimpleRecursiveTask(10000);
        System.out.println(pool.invoke(task));
    }
}
