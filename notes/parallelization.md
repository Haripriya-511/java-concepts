## Parallelization
Parallelization in Java refers to the process of dividing a task or a set of tasks into smaller subtasks that can be executed concurrently, often on multiple threads or cores of a CPU. This approach allows Java applications to take full advantage of modern multicore processors, resulting in improved performance and faster execution.

## Key Concepts of Parallelization in Java:
### Concurrency vs Parallelism:
- Concurrency involves multiple tasks making progress at the same time, but not necessarily simultaneously.
- Parallelism refers to tasks being executed exactly at the same time on multiple CPU cores.
### Thread:
- Java provides the Thread class and Runnable interface for creating and managing threads, which can run code concurrently.
### Fork/Join Framework:
- Introduced in Java 7, it is a framework designed to recursively split tasks into smaller subtasks (fork) and then combine their results (join).
- It uses a work-stealing algorithm, where idle threads can "steal" tasks from busy threads to improve efficiency.
- Example: RecursiveTask, RecursiveAction.
### Streams API (Java 8+):
- Java 8 introduced the Streams API, allowing parallel processing of data collections using parallelStream().
- Example:
```
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.parallelStream()
       .map(n -> n * 2)
       .forEach(System.out::println);
```
### Executor Framework:
- Provides a way to manage a pool of threads for executing tasks.
- Classes like ExecutorService and ScheduledExecutorService allow for flexible thread pool management.
### CompletableFuture (Java 8+):
- A powerful tool for asynchronous programming, enabling non-blocking operations and combining multiple tasks.
## Parallel Garbage Collection:
- Java Virtual Machine (JVM) uses parallel garbage collectors to manage memory more efficiently in multi-threaded applications.
## Challenges in Parallelization:
- Thread Safety: Multiple threads accessing shared resources can lead to data inconsistencies and race conditions.
- Overhead: Context switching and thread management can introduce overhead if tasks are too small or not well-optimized.
- Deadlocks: Improper thread synchronization can lead to threads waiting indefinitely.
## Parallel algorithms Examples

- **Parallel Merge Sort:**
  - Initial Split: The parallelMergeSort method divides the array into two halves.
  
  - Thread Creation: Two threads are created to sort each half in parallel.
  
  - Recursive Threading: The method continues dividing the halves further and spawning threads until the numOfThreads limit is reached.
  
  - Thread Joining: Once threads finish sorting their respective subarrays, the merge method is used to combine them.
  
  - Final Merge: The fully sorted halves are merged into a single sorted array.
- **Parallel Binary Search**
- **Parallel Breadth-First Search (BFS)**
- **Graph ALgorithms**
- **Divide-and-Conquer Algorithms**
- **Data Processing**
- **Dynamic Programming**


[Refer this example for parallel Merge sort](../multithreading/parallelalgorithms/ParallelMergeSort.java) \
[Refer this example for parallel sum](../multiThreading/parallelalgorithms/ParallelSumProblem.java)


