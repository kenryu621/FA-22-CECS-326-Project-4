package CPU_scheduler;

/**
 * Non-preemptive priority scheduling algorithm.
 */

import java.util.*;

// Your code here
public class Priority implements Algorithm {
    // Initialize private members
    private List<Task> taskQueue;

    // Overloaded constructor
    public Priority(List<Task> queue) {
        this.taskQueue = queue;
    }

    // Scheduling algorithm
    @Override
    public void schedule() {
        // Run and finish the tasks in priority order in the queue
        int length = taskQueue.size();
        for (int i = 0; i < length; ++i) {
            Task nextTask = pickNextTask();
            CPU.run(nextTask, nextTask.getBurst());
            System.out.println("Task " + nextTask.getName() + " finished.\n");
        }
    }

    // Return then remove the task with highest priority
    @Override
    public Task pickNextTask() {
        int highestPriority = 0;
        for (int i = 1; i < taskQueue.size(); ++i) {
            if (taskQueue.get(i).getPriority() > taskQueue.get(highestPriority).getPriority()) {
                highestPriority = i;
            }
        }
        return taskQueue.remove(highestPriority);
    }
}
