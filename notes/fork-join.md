## Fork/Join Framework

The Fork/Join Framework in Java is part of the java.util.concurrent package introduced in Java 7. It is designed to help developers leverage multi-core processors efficiently by simplifying parallel task execution. It accomplishes this through a divide and conquer approach.
## Key Concepts of Fork/Join Framework
- Divide-and-Conquer Approach:

  -The framework splits a large task into smaller sub-tasks (forking).
  -These smaller tasks are solved individually, often recursively.
  -The results of sub-tasks are then combined (joining) to produce the final result.
- Work-Stealing Algorithm:

  - Threads in the Fork/Join pool attempt to keep themselves busy.
  - If a thread has no tasks, it can "steal" tasks from other threads' queues.
- ForkJoinPool:

  - A special executor service designed to manage and execute tasks submitted to the Fork/Join framework.
  - It dynamically balances the workload among worker threads.
- ForkJoinTask:

  - Represents a task that can be forked and joined.
  - Two abstract classes implement ForkJoinTask:
    - RecursiveTask: For tasks that return a result.
    - RecursiveAction: For tasks that do not return a result.
## Step-by-Step Workflow:
- Define the Problem:Identify a task that can be split into smaller, independent subtasks.
- Create ForkJoinTask:Extend RecursiveTask or RecursiveAction to define the task's logic.
- Split Tasks:Implement the compute method to define how tasks are split and how results are combined.
- Submit to ForkJoinPool:Use a ForkJoinPool to execute the tasks.
## RecursiveAction
- A subclass of ForkJoinTask that is used when the task does not return a result.
- Suitable for problems where the operation modifies shared state or performs an action like sorting.
- Example Usecase:Sorting an array using merge sort, where the result is stored directly in the original array.
- [Refer this Example](../multithreading/forkjoinframework/PrintIntegersRecuriveAction.java)
- [Refer this Example](../multithreading/forkjoinframework/RecursiveActionExample.java)
## RecursiveAction
- A subclass of ForkJoinTask that is used when the task returns a result after computation.
- Suitable for problems where results from subtasks need to be combined to produce a final outcome.
- Example Use Case: Summing an array of numbers where the result of each subtask (sum of a segment) is combined to produce the total sum.
- [Refer this Example](../multithreading/forkjoinframework/RecursiveTaskExample.java)
- [Refer this Example](../multithreading/forkjoinframework/FibnocciTaskExample.java)
- [Refer this Example](../multithreading/forkjoinframework/MaximumFindingProblem.java)
compute,join,invoke,invokeAll,excute,fork
## Key Methods
- **fork()**
  - Asynchronously schedules a subtask for execution.
  - Purpose: Allows a thread to "fork" off a subtask and continue working on other tasks.
  - Used to submit a subtask to the ForkJoinPool for execution.
  - Non-blocking call
- **compute()**
  - Contains the core logic of your task.
  - This method must be overridden in your subclass of RecursiveAction or RecursiveTask.
  - Called automatically by the Fork/Join Framework when a task is executed.
  - Used internally when a task is submitted to the ForkJoinPool.
  - Never call compute() directly from outside the task class.
  - The framework invokes it when the task is processed.
- **join()**
  - Waits for the completion of a previously forked task and retrieves its result.
  - It blocks the current thread until the forked task completes.
  - To synchronize and combine results from subtasks after they have been split and executed.
  - Always used after calling fork().
  - Available in both RecursiveAction and RecursiveTask.
  - When you need the result of a subtask to continue execution.
-  **invoke()**
    -  Executes a task synchronously and waits for its completion.
    -  A convenience method to execute a task directly on the caller's thread.
    -  Combines the behavior of fork() and join() for a single task.
    - Blocks the current thread until the task is completed.
    - Use invoke() when you want to execute a task and get the result immediately, without splitting it into subtasks.
- **invokeAll()**
  - Definition: A convenience method that forks multiple tasks and waits for them to complete.
  - Purpose: Simplifies the process of forking and joining multiple tasks.
  - Accepts two or more tasks, forks them, and joins their results.
- **execute()**
  - Submits a task to the ForkJoinPool for execution but does not block the current thread.
  - The task is scheduled for asynchronous execution.
  - Purpose:To initiate the execution of a task without waiting for its result.
  - Key Characteristics: Non-blocking.
  - Does not return a result.
  - If you need the result, combine it with join().
  - When to Use: Use execute() to start a task when you don't need to wait for its completion.




   
    
