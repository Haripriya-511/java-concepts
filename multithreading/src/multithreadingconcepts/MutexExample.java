package multithreadingconcepts;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexExample {
    private static int counter=0;
    private static Lock mutex=new ReentrantLock(true);
    public static void main(String[] args) {
        Runnable task=()->{
            for(int i=0;i<5;i++){
                mutex.lock();
                try{
                    counter++;
                    System.out.println(Thread.currentThread().getName()+" incremented to:"+counter);
                }finally {
                    mutex.unlock();
                }
                try{
                    Thread.sleep(100);
                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }
        };
        new Thread(task,"T1").start();
     new Thread(task,"T2").start();;

    }
}
