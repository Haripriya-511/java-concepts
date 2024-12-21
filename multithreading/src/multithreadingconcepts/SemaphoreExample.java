package multithreadingconcepts;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        // Create a semaphore with 3 permits
        Semaphore semaphore = new Semaphore(3);

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                System.out.println(threadName + " trying to acquire a permit...");
                semaphore.acquire(); // Acquire a permit
                System.out.println(threadName + " acquired a permit. Available permits: " + semaphore.availablePermits());

                // Simulate work
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // Release the permit
                System.out.println(threadName + " released a permit. Available permits: " + semaphore.availablePermits());
            }
        };

        // Create and start 5 threads
        for (int i = 1; i <= 5; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
/*
*
*
Thread-2 trying to acquire a permit...
Thread-1 trying to acquire a permit...
Thread-3 trying to acquire a permit...
Thread-4 trying to acquire a permit...
Thread-5 trying to acquire a permit...
Thread-1 acquired a permit. Available permits: 1
Thread-3 acquired a permit. Available permits: 0
Thread-2 acquired a permit. Available permits: 2
Thread-4 acquired a permit. Available permits: 2
Thread-5 acquired a permit. Available permits: 1
Thread-1 released a permit. Available permits: 3
Thread-3 released a permit. Available permits: 3
Thread-2 released a permit. Available permits: 3
Thread-4 released a permit. Available permits: 2
Thread-5 released a permit. Available permits: 3

* */