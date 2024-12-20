package multithreadingconcepts;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockProblem {
    private final Lock lock1=new ReentrantLock(true);
    private final Lock lock2=new ReentrantLock(true);

    public static void main(String[] args) {
        DeadLockProblem problem=new DeadLockProblem();
        new Thread(problem::worker1,"Worker1").start();
        new Thread(problem::worker2,"Worker2").start();
    }
    public void worker1(){
        lock1.lock();
        System.out.println("worker1 acquires the lock1...");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
        System.out.println("worker1 acquired the lock2...");

        lock1.unlock();
        lock2.unlock();


    }
    public void worker2(){
        lock2.lock();
        System.out.println("worker2 acquires the lock2...");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock1.lock();
        System.out.println("worker2 acquired the lock1...");

        lock1.unlock();
        lock2.unlock();


    }
}
