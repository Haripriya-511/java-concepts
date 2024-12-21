package executorthreads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StokMartketUpdater implements Runnable{

    @Override
    public void run() {
        System.out.println("Updating and downloading stock market related data from web..."+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
public class ScheduledThreadPoolEx {
    public static void main(String[] args) {
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(5);

        executorService.scheduleAtFixedRate(new StokMartketUpdater(),1000,2000, TimeUnit.MILLISECONDS);
        //executorService.shutdown();
    }
}
