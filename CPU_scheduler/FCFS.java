package CPU_scheduler;

/**
 * FCFS scheduling algorithm.
 */

import java.util.*;

// Your code here
public class FCFS implements Algorithm {
    // Initialize private members
    private List<Task> taskQueue;

    // Overloaded constructor
    public FCFS(List<Task> queue) {
        this.taskQueue = queue;
    }

    // Scheduling algorithm
    @Override
    public void schedule() {
        // Run and finish tasks in first come first serve according to the order in
        // queue and pop the task from the queue
        int length = taskQueue.size();
        for (int i = 0; i < length; i++) {
            Task nextTask = pickNextTask();
            CPU.run(nextTask, nextTask.getBurst());
            System.out.println("Task " + nextTask.getName() + " finished.\n");
        }
    }

    // Return then remove the first task on the queue
    @Override
    public Task pickNextTask() {
        return taskQueue.remove(0);
    }
}
