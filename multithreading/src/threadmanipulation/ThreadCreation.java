package threadmanipulation;

class Runner1 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Runner1:"+i);
        }

    }
}
class Runner2 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Runner2:"+i);
        }
    }
}
class Thread1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Runner3:"+i);
        }
    }
}
public class ThreadCreation {
    //uisng runnable
    public static void main(String[] args) {
    Thread t1=new Thread(new Runner1());
    t1.start();
    Thread t2=new Thread(new Runner2());
    t2.start();
    //using Thread class
    Thread t3=new Thread1();
    t3.start();
        //using anonymous class
    Thread t4=new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println("Runner4:"+i);
            }
        }
    });
    t4.start();
        Thread1 t5=new Thread1();
        t5.start();

        //using lambda
        Thread t6= new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println("Runner6:"+i);
            }
        });
        t6.start();

    }
}
