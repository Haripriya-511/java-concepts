package diningphilosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {
    private final int id;
    private final Lock lock;
    public ChopStick(int id){
        this.id=id;
        this.lock=new ReentrantLock();
    }
    public boolean pickUp(Philosopher philosopher,State state) throws InterruptedException {
        // this is where we will simulate deadlock
       if(lock.tryLock(10, TimeUnit.MILLISECONDS)){
           System.out.println(philosopher+" picked up "+state.toString()+" "+this);
            return true;
        }
       return false;
    }
    public void putDown(Philosopher philosopher,State state){
        lock.unlock();
        System.out.println(philosopher+" put down "+state.toString()+" "+this);
    }

    @Override
    public String toString() {
        return "Chopstick "+id;
    }
}
