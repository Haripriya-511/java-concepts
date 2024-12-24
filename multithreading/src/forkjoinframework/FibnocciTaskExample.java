package forkjoinframework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class FibnocciTask extends RecursiveTask<Integer>{
    private int num;
    public FibnocciTask(int n){
        this.num=n;
    }

    @Override
    protected Integer compute() {
    if(num<=1)
        return num;
    FibnocciTask task1=new FibnocciTask(num-1);
        FibnocciTask task2=new FibnocciTask(num-2);
    //task1.fork();
    task2.fork();
        //actual thread executes the fib1
        // and we create another thread (insert it into the pool)
        // associated with fib2
    return task1.compute()+task2.join();
    }
}
public class FibnocciTaskExample {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new FibnocciTask(25)));
    }
}
