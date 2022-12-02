package CPU_scheduler;

/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 */

import java.util.*;

// Your code here
public class RR implements Algorithm {
    // Initialize private members
    private int RRindex;
    private List<Task> taskQueue;

    // Overloaded constructor
    public RR(List<Task> queue) {
        this.RRindex = 0;
        this.taskQueue = queue;
    }

    // Scheduling algorithm
    @Override
    public void schedule() {
        // Run the algorithm until the queue is empty
        while (taskQueue.size() != 0) {
            Task nextTask = pickNextTask();
            int sliceTime = nextTask.getBurst() > 10 ? 10 : nextTask.getBurst();
            CPU.run(nextTask, sliceTime);
            // If the task's CPU burst time is under 10, task is finished and removed from
            // the queue
            if (nextTask.getBurst() <= 10) {
                System.out.println("Task " + nextTask.getName() + " finished.\n");
                taskQueue.remove(taskQueue.indexOf(nextTask));
                // The index should return to original once a task is removed from the queue
                if (taskQueue.size() != 0 && RRindex > 0)
                    --RRindex;
            } else { // Else, reduce the CPU burst time by 10
                nextTask.setBurst(nextTask.getBurst() - 10);
            }
        }
    }

    // Return the task in the queue's order and go back to the first index if it
    // reached the end
    @Override
    public Task pickNextTask() {
        Task upcomingTask = taskQueue.get(RRindex);
        RRindex = ++RRindex % taskQueue.size();
        return upcomingTask;
    }
}