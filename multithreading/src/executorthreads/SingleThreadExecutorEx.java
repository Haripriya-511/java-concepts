package executorthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{
    private int id;
    public Task(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
    public void setId(){
        this.id=id;
    }

    @Override
    public void run() {
        System.out.println("Task:"+id+"executed by:"+Thread.currentThread().getName());
        long duration= (long) (Math.random()*5);
        try{
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }


    }
}
public class SingleThreadExecutorEx {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Runnable task =()->{
            System.out.println("Task executed by:"+Thread.currentThread().getName());
        };
        for(int i=0;i<5;i++) {
            executorService.execute(new Task(i));
        }
        executorService.shutdown();
    }
}
