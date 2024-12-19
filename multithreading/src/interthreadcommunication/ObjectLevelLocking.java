package interthreadcommunication;

public class ObjectLevelLocking {
    public void performTask() {
        System.out.println(Thread.currentThread().getName() + " is entering performTask.");
        synchronized (this) { // Object-level lock
            System.out.println(Thread.currentThread().getName() + " has acquired object-level lock.");
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is releasing object-level lock.");
        }
        System.out.println(Thread.currentThread().getName() + " has exited performTask.");
    }

    public static void main(String[] args) {
        ObjectLevelLocking obj = new ObjectLevelLocking();

        Thread t1 = new Thread(obj::performTask, "Thread-1");
        Thread t2 = new Thread(obj::performTask, "Thread-2");

        t1.start();
        t2.start();
    }
}
