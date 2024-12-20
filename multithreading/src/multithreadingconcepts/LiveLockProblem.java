package multithreadingconcepts;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLockProblem {
    private final Lock lock1=new ReentrantLock(true);
    private final Lock lock2=new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        LiveLockProblem lockProblem = new LiveLockProblem();

        Thread t1 = new Thread(() -> {
            try {
                lockProblem.worker1();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Handle interruption
            }
        }, "T1");

        Thread t2 = new Thread(() -> {
            try {
                lockProblem.worker2();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Handle interruption
            }
        }, "T2");

        t1.start();
        t2.start();
    }

    private void worker1() throws InterruptedException {

        while(true){
            lock1.tryLock(50, TimeUnit.MILLISECONDS);
            System.out.println("worker1 acquired lock1...trying for lock2");
            Thread.sleep(50);
            if(lock2.tryLock()){
                System.out.println("worker1 acquired lock2...");
            }else{
                System.out.println("worker1 cannot acquire lock2, releasing lock1");
                lock1.unlock();
                continue;
            }
            break;

        }
        lock2.unlock();
        lock1.unlock();
    }
    private void worker2() throws InterruptedException {
        while(true){
            lock2.tryLock(50, TimeUnit.MILLISECONDS);
            System.out.println("worker2 acquired lock2...trying for lock1");
            Thread.sleep(50);
            if(lock1.tryLock()){
                System.out.println("worker2 acquired lock1...");
            }else{
                System.out.println("worker2 cannot acquire lock1, releasing lock2");
                lock2.unlock();
                continue;
            }
            break;

        }
        lock2.unlock();
        lock1.unlock();

    }
}
