

Livelocks and deadlocks are both concurrency issues that occur in multi-threaded programs.
## 1.Deadlock
### Definition
A deadlock occurs when two or more threads are blocked forever, waiting for each other to release resources. This results in the threads being unable to proceed.
### How to Resolve
- **Avoid Nested Locks: **Minimize the use of nested synchronized blocks.
- **Lock Ordering:** Always acquire locks in a consistent, predefined order.
- **Timeouts:** Use tryLock() with a timeout in classes like ReentrantLock.
- [refer this example](./multithreading/src/multithreadingconcepts/DeadLockProblem.java)
