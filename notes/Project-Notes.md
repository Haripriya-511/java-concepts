
## ThreadPool

A ThreadPool is a collection of pre-initialized threads that are reused to execute tasks. Instead of creating a new thread for every task, a thread pool reuses threads, minimizing the overhead of thread creation and destruction.
- Reusability:
Threads are reused, reducing resource consumption.
- Task Queueing:
Tasks are queued if all threads are busy.
- Better Performance:
Reduces the overhead of frequent thread creation.
- Controlled Concurrency:
Limits the number of concurrent threads to prevent resource exhaustion.
- ThreadPool is a design pattern where a fixed number of threads are created and reused to execute tasks, avoiding the overhead of thread creation and destruction for every task.

## Executor Framework
The Executor framework is a mechanism to manage and control thread creation and execution. It decouples the task (Runnable/Callable) from the thread that executes it, allowing tasks to be submitted for execution without explicitly managing threads.
The Executor framework in Java is part of the java.util.concurrent package and provides a high-level API for managing threads, offering better flexibility and control compared to manually creating threads.
A high-level framework introduced in Java 5 as part of the java.util.concurrent package to provide an abstraction for managing and controlling thread execution.
- Decoupling task submission from thread management.
- Providing a reusable pool of threads.
- Managing thread lifecycle automatically.



## Executors
The Executors class is a utility class that provides factory methods to create different types of thread pools. It hides the complexity of creating and configuring thread pools, making it easier to use.

### How to Create Threads Using Executors
- #### SingleThreadExecutor
  - Creates a thread pool with one thread.
  - Tasks are executed sequentially in the single thread.
  - Useful when tasks must execute in order.
  - [Refer this example](../multithreading/src/executorthreads/SingleThreadExecutorEx.java)

- #### FixedThreadPool
  - Creates a thread pool with a fixed number of threads.
  - Threads are reused for multiple tasks.
  - Useful when tasks must execute in order.
  - [Refer this example](../multithreading/src/executorthreads/FixedThreadPoolExample.java)

- ### CachedThreadPool
  - Creates a thread pool with a variable number of threads.
  - Creates new threads as needed and reuses idle threads.
  - Suitable for tasks with varying durations
  -  [Refer this example](../multithreading/src/executorthreads/CachedThreadPoolEx.java)

- ### ScheduledThreadPool
  - Creates a thread pool for scheduling tasks.
  - Tasks can run after a delay or periodically
  - [Refer this example](../multithreading/src/executorthreads/ScheduledThreadPoolEx.java)


## Executor 
- A simple interface with a void execute(Runnable command) method.
- Subclasses like ExecutorService add advanced functionality.
- The execute() method accepts a Runnable task and executes it.
 ```
   @FunctionalInterface
public interface Executor {
    void execute(Runnable command);
}
```
## ExecutorService
- Extends Executor and provides lifecycle methods like shutdown(), shutdownNow(), and task submission methods like submit()
- The ExecutorService is a more advanced subinterface of Executor. It provides methods to manage thread lifecycle, submit tasks, and retrieve results.
- Tasks can be submitted using submit() or execute() methods.
- Tasks submitted via submit() return a Future object, allowing the retrieval of task results.
- Executors can be gracefully shut down using shutdown() or forcefully using shutdownNow().
- awaitTermination()	Waits for tasks to complete within a specified time.
- [Refer this example](../multithreading/src/executorthreads/ExecutorServiceExample.java)

## ThreadPoolExecutor
- The most configurable implementation of ExecutorService.
- Allows fine-grained control over thread pool behavior.
- The ThreadPoolExecutor class provides full control over thread pool behavior:
  - Core thread count.
  - Maximum thread count.
  -  idle thread timeout
- Manages pending tasks using queues.
- Policy Management: Defines policies for handling tasks when the pool reaches its limits (e.g., reject tasks, block, or discard).
```
ThreadPoolExecutor(
    int corePoolSize,           // Minimum number of threads in the pool
    int maximumPoolSize,        // Maximum number of threads in the pool
    long keepAliveTime,         // Time to keep extra threads alive when idle
    TimeUnit unit,              // Time unit for keepAliveTime
    BlockingQueue<Runnable> workQueue,  // Queue to hold pending tasks
    ThreadFactory threadFactory,        // Factory to create new threads
    RejectedExecutionHandler handler    // Policy for rejected tasks
)
```
- Core Pool Size:The minimum number of threads maintained in the pool, even if they are idle.
- Maximum Pool Size:The maximum number of threads allowed in the pool.
- Keep Alive Time:The maximum time that idle threads above the core pool size are kept alive before being terminated.
- Work Queue:A queue to hold tasks before they are executed. Types include:
  - SynchronousQueue: Direct handoff to threads, no queueing.
  - LinkedBlockingQueue: Unbounded queue.
  - ArrayBlockingQueue: Bounded queue with fixed size.
- Thread Factory:Custom factory to create new threads with specific configurations.
- Rejected Execution Handler:A policy for handling tasks when the queue is full and all threads are busy:
  - AbortPolicy: Throws RejectedExecutionException.
  - CallerRunsPolicy: Runs the task in the caller’s thread.
  - DiscardPolicy: Discards the task silently.
  - DiscardOldestPolicy: Discards the oldest unprocessed task.
- Thread Lifecycle in ThreadPoolExecutor
  - **Task Submission:** When task is submitted If the number of active threads is less than corePoolSize, a new thread is created to handle the task.
If corePoolSize is reached, tasks are added to the work queue.
  - **Handling Queued Tasks:** If the work queue is full and threads are less than maximumPoolSize, new threads are created to handle tasks.
Once the maximum pool size is reached, the rejection policy is applied.
  - **Idle Threads:** Threads beyond corePoolSize that remain idle for keepAliveTime are terminated.
- [Refer this example](../multithreading/src/executorthreads/ThreadPoolExecutorExample.java)


## ScheduledExecutorService
- Extends ExecutorService for scheduling tasks to execute periodically or after a delay.
- used to implement ScheduledThreadPools
## Shutting Down Executors
- Graceful Shutdown (shutdown()): Allows tasks that are currently running to finish, but no new tasks will be accepted.
 ```
  ExecutorService executor = Executors.newFixedThreadPool(2);
executor.shutdown();  // Gracefully shuts down after completing tasks
```
- Immediate Shutdown (shutdownNow()): Attempts to stop all actively executing tasks, interrupts any ongoing tasks.
```
ExecutorService executor = Executors.newFixedThreadPool(2);
executor.shutdownNow();  // Immediately stops all tasks
```
- awaitTermination(): Blocks until all tasks are completed or the timeout occurs.
```
executor.shutdown();
try {
    if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
        executor.shutdownNow();
    }
} catch (InterruptedException e) {
    executor.shutdownNow();
}
```
## Callable Interface
- Introduced in Java 5.
- Represents a task that returns a result and can throw checked exceptions.
- Key Features
- Return Value:
- The call() method returns a result.The return type is specified using generics (Callable<V>).
```
  @FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}
```
```
import java.util.concurrent.Callable;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        Callable<String> task = () -> {
            Thread.sleep(1000); // Simulate a delay
            return "Result from Callable Task";
        };

        // Direct call (usually submitted to ExecutorService)
        System.out.println(task.call());
    }
}
```
- A Callable task is typically submitted to an ExecutorService, which returns a Future object. The Future can be used to retrieve the result or manage the task.
## Future Interface
- Represents the result of an asynchronous computation.
- Methods:
    - get(): Blocks until the result is available.
    - cancel(): Cancels the task.
    - isDone(): Checks if the task is completed.
- [Refer this example](../multithreading/src/executorthreads/CallableExample.java)
### Use Callable When:
- The task needs to return a result.
- You need to handle checked exceptions.
- The task involves complex computation, database queries, or external API calls.




  







 

