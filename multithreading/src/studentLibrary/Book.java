package studentLibrary;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
    private int id;
    private Lock lock;
    public Book(int id){
        this.id=id;
        this.lock=new ReentrantLock(true);
    }
public void read(Student student) throws InterruptedException{
       if(lock.tryLock(1, TimeUnit.SECONDS)) {
           try {
               System.out.println(student + " starts reading " + this);
               Thread.sleep(2000);
           }finally {
               lock.unlock();
               System.out.println(student + " finished reading " + this);
           }
       }
       else{
           System.out.println(student + " couldn't acquire " + this);
       }
}
    @Override
    public String toString() {
        return "Book"+id;
    }
}
