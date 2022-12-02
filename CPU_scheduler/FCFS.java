package CPU_scheduler;

/**
 * FCFS scheduling algorithm.
 */

import java.util.*;

// Your code here
public class FCFS implements Algorithm {
    private int firstCome;
    private List<Task> taskQueue;

    public FCFS(List<Task> queue) {
        this.firstCome = 0;
        this.taskQueue = queue;
    }

    @Override
    public void schedule() {
        for (int i = 0; i < taskQueue.size(); i++) {
            Task nextTask = pickNextTask();
            CPU.run(nextTask, nextTask.getBurst());
            System.out.println("Task " + nextTask.getName() + " finished.\n");
        }
    }

    @Override
    public Task pickNextTask() {
        return taskQueue.get(firstCome++);
    }
}
