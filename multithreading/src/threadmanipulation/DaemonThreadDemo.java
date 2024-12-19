package threadmanipulation;

class DaemonWorker implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from daemon worker...");

        }
    }
}
class NormalWorker implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Normal worker finishes work...");

    }
}
public class DaemonThreadDemo {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println(name);

        Thread daemon=new Thread(new DaemonWorker());
        daemon.setDaemon(true);
        System.out.println(daemon.isDaemon());
        daemon.start();

        Thread normal=new Thread(new NormalWorker());
       normal.start();



    }
}
