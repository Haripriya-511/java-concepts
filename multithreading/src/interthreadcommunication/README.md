
<h1 style="color:green; ">1.What Does Sequential Execution Mean?</h1>

### Sequential execution means that only one thread at a time can enter the synchronized block.
**For example**:

— Thread-1 starts and acquires the lock.\
While Thread-1 is executing the synchronized block, Thread-2 must wait until Thread-1 finishes and releases the lock.\
-After Thread-1 finishes, Thread-2 acquires the lock and starts execution.\-Thus, the threads execute one after the other, not concurrently, within the synchronized block.

<h1 style="color:green; ">2. What Does Locking the Class Object Mean?</h1>
 In Java, when you use a synchronized block with ClassName.class, it locks the Class object.
Every Java class has a unique Class object associated with it in the JVM. This Class object represents the entire class's blueprint (metadata and structure).
When a thread enters a synchronized(ClassName.class) block:
The thread acquires a lock on the Class object (ClassName.class).
-This lock ensures that no other thread can enter any synchronized(ClassName.class) block in the entire JVM for that class until the lock is released. \


<h1 style="" >3.How Class-Level Locking Works</h1>
-Thread-1 calls method1 of class:\
-It enters the synchronized(ClassLevel.class) block.\
-It acquires the lock on ClassLevel.class.\
-Thread-2 tries to call method1:\
-It attempts to enter the synchronized(ClassLevel.class) block.\
-It is blocked because Thread-1 already holds the lock.\
-It must wait until Thread-1 releases the lock.\
-Once Thread-1 finishes and exits the block, it releases the lock.\
-Thread-2 acquires the lock and proceeds.\


<h1 style="color:green; ">4.Scenario</h1>
If there are two synchronized blocks, both using synchronized(ClassName.class), they share the same class-level lock. For example:
Thread-1 (T1) enters method1 and acquires the class-level lock (ClassLevelLocking.class).
While T1 is holding the lock:
Thread-2 (T2) tries to enter method2.
T2 cannot proceed because the lock is already held by T1.
Once T1 finishes execution and releases the lock, T2 acquires the lock and proceeds.

<h1 style="color:green; ">5.How Object-Level Lock Works</h1>
Object-level locking ensures that only one thread can access the synchronized block or method on a specific object instance at a time.
The lock is tied to the instance (this) of the class.
Key Points:\
-If multiple threads access synchronized methods or blocks on the same object, only one thread can execute at a time.\
-If threads access synchronized methods or blocks on different objects, they can execute concurrently.\