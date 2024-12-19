package threadmanipulation;

public class PriorirtyDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());
        Thread t1=new Thread(() -> {
            for (int i = 0; i < 10; i++)
                System.out.println(i);
        });
        t1.setPriority(Thread.MAX_PRIORITY);
       // t1.setPriority(6);//illegal argument exception
        t1.start();
        // main thread
        System.out.println("This is in the main thread...");


    }
}
