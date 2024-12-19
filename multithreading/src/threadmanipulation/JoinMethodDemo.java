package threadmanipulation;
class Method{
    public  static void run(){
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

public class JoinMethodDemo {

    public static void main(String[] args) {
        Runnable runnable= Method::run;
        Thread t1=new Thread(runnable,"thread1");
        Thread t2=new Thread(runnable,"thread2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finishing main thread...");
    }
}
