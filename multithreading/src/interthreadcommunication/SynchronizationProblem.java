package interthreadcommunication;

public class SynchronizationProblem {
    public  static int counter=0;
    public static void process(){
        Thread t1=new Thread(() -> {
            for(int i=0;i<100;i++)
                counter++;
        });
        Thread t2=new Thread(() -> {
            for(int i=0;i<100;i++)
                counter++;
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("counter:"+counter);
    }
    public static void main(String[] args) {
process();
    }
}
