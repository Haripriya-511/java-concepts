## Dining Philosophers Problem
The Dining Philosophers Problem is a classical synchronization challenge in concurrent programming. It involves five philosophers seated at a circular table, alternating between thinking and eating. To eat, a philosopher requires two chopsticks: one on their left and one on their right. This code provides a solution to avoid deadlock and starvation.

## Problem Statement
- Philosophers:
  - Philosophers alternate between two states: thinking and eating.
  - They need two chopsticks to eat: one on their left and one on their right.
- Challenges:
  - Deadlock: If all philosophers pick up one chopstick simultaneously, they will wait indefinitely for the second chopstick.
  - Starvation: A philosopher may never eat if neighbors constantly monopolize the chopsticks.
- Goals:
  - Ensure no deadlock or starvation.
  - Allow all philosophers to eat fairly.
## Code WalkThrough
### Application(Main Class)
- Initializes the number of philosophers and chopsticks.
- Uses a fixed thread pool (Executors.newFixedThreadPool) to execute philosopher tasks concurrently.
- Simulation Running Time:
  - The simulation runs for a specified duration (SIMULATION_RUNNING_TIME) to observe behavior.
  - After this period, philosophers are marked as full, ending their tasks.
### ChopStick
- Uses a ReentrantLock to prevent simultaneous access to a chopstick by multiple philosophers.
- The pickUp method:
  - Attempts to acquire the lock on a chopstick within 10 milliseconds (tryLock with a timeout).
  - Returns true if successful, simulating the philosopher picking up the chopstick.
  - If unsuccessful, the philosopher waits briefly and retries.
- The putDown method:
  - Releases the lock, simulating putting down the chopstick.
### Philosopher
- Alternates between thinking and eating:
  - think: Simulates thinking with a random delay.
  - eat: Simulates eating, increments the eating counter, and introduces a delay.
- Uses two chopsticks (leftChopStick and rightChopStick) for eating.
- Prevents deadlock by using the tryLock method and releasing locks in reverse order after eating.
- Stops when marked as full.
### Constants
- NUMBER_OF_PHILOSOPHERS: Number of philosophers at the table.
- NUMBER_OF_CHOPSTICKS: Number of chopsticks (equal to the number of philosophers).
- SIMULATION_RUNNING_TIME: Duration of the simulation in milliseconds.
## How Deadlock and Starvation Are Avoided
**Deadlock Prevention**
- Non-Blocking Lock Acquisition:

  - Chopsticks use tryLock with a timeout, avoiding indefinite blocking.
  - If a philosopher cannot acquire both chopsticks, they release any acquired chopstick and retry.
- Resource Order:

  - Philosophers pick chopsticks in a consistent order (left first, then right), reducing the risk of circular waiting. 

**Starvation Prevention**
- Fair Resource Access:

  - Chopsticks are implemented with ReentrantLock, which ensures fair access by philosophers waiting for them.
- Simulation Time:

  - The simulation runs for a limited period, ensuring all philosophers eventually get a chance to eat.
## Simulation Running Time
- The simulation time (SIMULATION_RUNNING_TIME) provides a finite observation window:
  - Prevents an infinite loop in the program.
  - Allows us to measure and verify the performance (e.g., how many times each philosopher eats).
- Without it, the program could run indefinitely, especially in edge cases.
## Execution Flow
- Create five philosophers and five chopsticks.
- Assign each philosopher two chopsticks (left and right).
- Start philosophers' tasks in a thread pool.
- Run the simulation for the specified time.
- Stop the simulation by marking philosophers as full.
- Print the number of times each philosopher ate.
[Refer this program](../multithreading/src/diningphilosopher/Application.java)




