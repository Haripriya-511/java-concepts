package multithreadingconcepts;

import java.util.concurrent.Semaphore;

public class CountingSemaphore {
    public static void main(String[] args) {
        Semaphore parkingSlotes=new Semaphore(3);
        Runnable car=()->{
            String carName= Thread.currentThread().getName();

            try {
                System.out.println(carName+" is trying to park...");
                parkingSlotes.acquire();
                System.out.println(carName+" parked...");
                Thread.sleep(5000);
                System.out.println(carName+ " is leaving the parking slot...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                parkingSlotes.release();
                System.out.println(carName+" left");
            }
        };
        for(int i=1;i<=5;i++){
            new Thread(car,"Car-"+i).start();
        }
    }
}
