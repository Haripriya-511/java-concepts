package interthreadcommunication;

public class ClassLevelLocking {
    public void staticMethod() {
        System.out.println(Thread.currentThread().getName() + " is entering method...");
        synchronized (ClassLevelLocking.class) {
            System.out.println(Thread.currentThread().getName()+" has acquired class lock");
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" has released class lock");

        }

        System.out.println(Thread.currentThread().getName() + " is exiting method...");
    }

    public static void main(String[] args) {
        ClassLevelLocking obj1=new ClassLevelLocking();
        Thread t1 = new Thread(obj1::staticMethod, "Thread-1");
        Thread t2 = new Thread(obj1::staticMethod, "Thread-2");
        t2.start();
        t1.start();

    }
}
