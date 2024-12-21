

Livelocks and deadlocks are both concurrency issues that occur in multi-threaded programs.
## 1.Deadlock
### Definition
A deadlock occurs when two or more threads are blocked forever, waiting for each other to release resources. This results in the threads being unable to proceed.
[Refer this example](../multithreading/src/multithreadingconcepts/DeadLockProblem.java)

### How to Resolve
- **Avoid Nested Locks: **Minimize the use of nested synchronized blocks.
- **Lock Ordering:** Always acquire locks in a consistent, predefined order to avoid any cyclic dependency in lock acquisition
- **Timeouts:** Use tryLock() with a timeout in classes like ReentrantLock.

 ## 2.Livelock
  ### Definition
  A livelock occurs when two or more threads are actively responding to each other but fail to make progress.  In livelock, two or more threads keep on transferring states between one another instead of waiting infinitely as we saw in the deadlock.
  
  Both threads need two locks to complete their work. Each thread acquires its first lock but finds that the second lock is not available. So, in order to let the other thread complete first, each thread releases its first lock and tries to acquire both the locks again.
  [Refer this example](../multithreading/src/multithreadingconcepts/LiveLockProblem.java)
### How to Resolve
- **Backoff Strategy:** Introduce random delays before retrying.
- **Timeouts:** Set a limit on retries or time spent trying.
- **Communication:** Allow threads to negotiate and coordinate.

## 3.TryLock()
The tryLock() method in the java.util.concurrent.locks.Lock interface is a mechanism to acquire a lock without blocking indefinitely. It is part of the java.util.concurrent.locks.ReentrantLock class and provides flexibility in handling lock acquisition attempts.
- When a thread calls tryLock():
  - If the lock is available, the thread acquires it and continues execution.
  - If the lock is held by another thread, the method:
    -Returns false immediately in the no-argument variant **tryLock()** (No Arguments).
    -Waits up to the specified time in the time-bound variant before giving up **tryLock(long time, TimeUnit unit)**.

## 4.Atomic Variables
Atomic variables are designed to allow multiple threads to safely manipulate a shared variable without explicit synchronization. They use low-level hardware-supported atomic instructions like Compare-And-Swap (CAS) to ensure thread safety.
  [Refer this example](../multithreading/src/multithreadingconcepts/AtomicVariablesDemo.java)
### Types of Atomic Variables
  - 1.AtomicInteger :
      - Provides atomic operations for int values.
      - methods are get(),incrementAndGet(),decrementAndGet(),addAndGet(delta),compareAndSet(expected, update)

  - 2.AtomicLong : same as AtomicInteger
  - 3.AtomicBoolean
       - Provides atomic operations for boolean values.
       - Common use case: toggling or checking a flag in a thread-safe manner.
  - 4.AtomicReference
       - Provides atomic operations for objects
       - methods are get(),set(value),compareAndSet(expected, update)
  - 5.AtomicArray Classes
       - AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray provide atomic operations for array elements.
### When to Use Atomic Variables
- Thread Safety: When you need to update shared variables safely without locks.
- Performance: In scenarios with high contention where locks might cause bottlenecks.
- Counters/Flags: For maintaining counters or flags in concurrent environments.
### How they work
Atomic variables in Java ensure thread-safe, lock-free, and atomic operations using Compare-And-Swap (CAS) under the hood. 
- For example:
    - Incrementing a variable (x = x + 1) is not atomic in standard Java. It involves:
      - Reading the current value of x.
      - Adding 1 to it.
      - Writing the new value back.
- CAS is the fundamental operation used by atomic variables. It is a hardware-supported instruction available in most modern CPUs. Here's how CAS works:

    - Steps in CAS:
       - Read the Current Value: The current value of the variable is read.
       - Compare: The current value is compared to an expected value.
       - Swap:
If the current value matches the expected value, it is replaced with a new value.
If not, the operation fails, and the process can be retried

## 5.Semaphore

A Semaphore is a concurrency control mechanism in Java and other programming languages that helps manage access to shared resources. It is particularly useful when you need to limit the number of threads that can access a resource simultaneously.
- What is a Semaphore?
  - A Semaphore is a synchronization aid that controls access to a shared resource by maintaining a set of permits.
  - Threads must acquire a permit before accessing the resource and release the permit when done.
  -   [Refer this example for semaphore](../multithreading/src/multithreadingconcepts/SemaphoreExample.java)
  -     -   [Refer this example for counting semaphore](../multithreading/src/multithreadingconcepts/CountingSemaphore.java)
- How Semaphore Works?
A semaphore maintains an internal counter:

  - **Initialization**: The counter is set to the maximum number of permits.
  - **Acquire**:
Decreases the counter by 1.
If the counter is 0, the thread waits until a permit becomes available.
  - **Release**:
Increases the counter by 1.
Notifies a waiting thread (if any) that a permit is available.
- key methods are acquire(),release(),tryAcquire(), availablePermits()
- Real world use cases
   - rate limiting
   - resource pooling: Managing a fixed number of database connections, thread pools, etc.
   - Bounded Buffers: Ensuring that producers and consumers access a limited-size buffer properly.
 
## 6.Binary Semaphore
- A Binary Semaphore is a semaphore initialized with a maximum of one permit.
- It can be used for synchronization or mutual exclusion, but it doesn't strictly enforce ownership.
- Threads can acquire and release permits without being the "owner" of the permit.
-   [Refer this example](../multithreading/src/multithreadingconcepts/BinarySemaphore.java)
## 7.Mutex
  - A Mutex is specifically designed for mutual exclusion and enforces ownership.
  - Only the thread that acquires the lock can release it.
  -   [Refer this example](../multithreading/src/multithreadingconcepts/MutexExample.java)
### When to Use Which?
- Binary Semaphore:
Use when you need signaling between threads or synchronization without strict ownership (e.g., one thread signals another to proceed).
- Mutex:
Use for protecting critical sections of code where ownership and exclusive access are essential (e.g., modifying shared data).
- Binary Semaphore and Mutex are similar in allowing only one thread to access a resource but differ in ownership and purpose
- ReentrantLock (Mutex) is a more flexible and powerful alternative to synchronized, offering features like fairness, try-lock, interruptible locking, and condition variables.
- synchronized is simpler and often sufficient for basic use cases.
- Use Mutex (ReentrantLock) when you need explicit control, fairness, or want to handle more complex locking scenarios.
#### Ownership:
Difference between binary sempahore and mutex is ownership constraints
- No Ownership: A binary semaphore does not enforce ownership.
- Any Thread Can Release: A thread that did not acquire the semaphore can release it. This makes binary semaphores more flexible but also prone to misuse, as releasing a semaphore by an unrelated thread can lead to unexpected behavior.
- Only the Owner Can Release: The thread that acquires the mutex must release it. If another thread attempts to release the mutex, it will typically result in an error or undefined behavior.













    

  
