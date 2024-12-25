package virtualthread;

import java.time.Duration;
import java.util.concurrent.Executors;

class VirtualTask implements Runnable{

    @Override
    public void run() {
        System.out.println("Started..."+Thread.currentThread().getName());
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Finish..."+Thread.currentThread().getName());

    }
}
public class VirtualThreadCreation {
    public static void main(String[] args) throws InterruptedException {
//    var builder=Thread.ofVirtual().name("Virtual-",0);
//
//    Thread t1=builder.start(new VirtualTask());
//    Thread t2=builder.start(new VirtualTask());
//    // all virtual threads are daemon threads
//        t1.join();
//        t2.join();
       var service= Executors.newVirtualThreadPerTaskExecutor();
       for(int i=0;i<1000;i++){
           service.submit(()->{
               try{
                   System.out.println("Thread "+Thread.currentThread());
                   Thread.sleep(Duration.ofSeconds(1));
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
           });


       }

    }
}
