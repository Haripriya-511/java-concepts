package executorthreads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(
                2,4,30, TimeUnit.SECONDS,new ArrayBlockingQueue<>(2)
                , Executors.defaultThreadFactory()
                ,new ThreadPoolExecutor.AbortPolicy()
        );
        for(int i=1;i<=5;i++){
            int taskNumber=i;
            executor.submit(()->{
                System.out.println("Executing Task " + taskNumber + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

        }
        executor.shutdown();
    }
}
