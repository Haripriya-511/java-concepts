package forkjoinframework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class SimpleRecursiveaction extends RecursiveAction{
    private int simulateWork;
    public SimpleRecursiveaction(int simulateWork){
        this.simulateWork=simulateWork;
    }
    @Override
    protected void compute() {
//if task is too large too large then we split and execute the tasks in paraller
        if(simulateWork>100){
            System.out.println("Parallel execution split the tasks..."+simulateWork);
            SimpleRecursiveaction action1 =new SimpleRecursiveaction(simulateWork/2);
            SimpleRecursiveaction action2=new SimpleRecursiveaction(simulateWork/2);
//            action1.fork();
//            action2.fork();
//            action1.join();
//            action2.join();
            invokeAll(action1,action2);

        }
        else{
            System.out.println("The task is rather small so sequential execution is fine...");
            System.out.println("size of the task:"+simulateWork);
        }
    }
}
public class RecursiveActionExample {
    public static void main(String[] args) {
        ForkJoinPool pool=new ForkJoinPool();
        SimpleRecursiveaction action=new SimpleRecursiveaction(800);
        pool.invoke(action);

    }
}
