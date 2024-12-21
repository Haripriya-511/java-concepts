package multithreadingconcepts;

import java.util.concurrent.Semaphore;

public class BinarySemaphore {
    private static Semaphore semaphore=new Semaphore(1);
    private static int sharedResource=0;

    public static void main(String[] args) {
        Thread producer=new Thread(()->{
            try{
                while (true){
                    semaphore.acquire();
                    sharedResource++;
                    System.out.println("produced:"+sharedResource);
                    Thread.sleep(2000);
                    semaphore.release();
                }
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }

        });
        Thread consumer=new Thread(()->{
            try{
                while (true){
                    semaphore.acquire();
                    System.out.println("consumed:"+sharedResource);
                    Thread.sleep(2000);
                    semaphore.release();
                }
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }

        });
        producer.start();
        consumer.start();
    }
}
