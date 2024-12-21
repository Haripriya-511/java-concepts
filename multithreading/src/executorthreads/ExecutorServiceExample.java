package executorthreads;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        for(int i=1;i<=5;i++){
            executorService.execute(()-> System.out.println("Task executed by: "+Thread.currentThread().getName()));
        }

        // Submitting Callable tasks
        Future<Integer> future = executorService.submit(() -> {
            Thread.sleep(2000); // Simulate computation
            return 42;          // Return a result
        });
        try {
            System.out.println("Result from Callable: " + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
