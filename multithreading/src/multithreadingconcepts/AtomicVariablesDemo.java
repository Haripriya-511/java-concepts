package multithreadingconcepts;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicVariablesDemo {
    private static final AtomicInteger counter=new AtomicInteger(0);
    private static final AtomicBoolean flag = new AtomicBoolean(false);
    private static final AtomicReference<String> sharedResource = new AtomicReference<>("Initial");

    public static void main(String[] args) throws InterruptedException {
        AtomicVariablesDemo demo=new AtomicVariablesDemo();
        Thread t1=new Thread(demo::worker1,"T1");
        Thread t2=new Thread(demo::worker1,"T2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counter from main:"+counter);

        Thread t3 = new Thread(demo::worker3,"T3");

        Thread t4 = new Thread(demo::worker3,"T4");

        t3.start();
        t4.start();

        Thread t5=new Thread(demo::worker2,"T5");
        Thread t6=new Thread(demo::worker2,"T6");
        t5.start();
        t6.start();
    }
    private void worker3(){
        if (flag.compareAndSet(false, true)) {
            System.out.println(Thread.currentThread().getName()+" set the flag to true");
        } else {
            System.out.println(Thread.currentThread().getName()+" found the flag already set");
        }
    }
    private void worker1(){
        for(int i=0;i<10;i++){
            counter.getAndIncrement();
        }
    }
    private void worker2(){

            if (sharedResource.compareAndSet("Initial", "Updated")) {
                System.out.println(Thread.currentThread().getName() + " updated the value");
            } else {
                System.out.println(Thread.currentThread().getName() + " found the value already updated");
            }
        }

    }

