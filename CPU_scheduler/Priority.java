package CPU_scheduler;

/**
 * Non-preemptive priority scheduling algorithm.
 */

import java.util.*;

// Your code here
public class Priority implements Algorithm {
    private List<Task> taskQueue;

    public Priority(List<Task> queue) {
        this.taskQueue = queue;
    }

    @Override
    public void schedule() {
        // TODO Auto-generated method stub
        int length = taskQueue.size();
        for (int i = 0; i < length; ++i) {
            Task nextTask = pickNextTask();
            CPU.run(nextTask, nextTask.getBurst());
            System.out.println("Task " + nextTask.getName() + " finished.\n");
        }
    }

    @Override
    public Task pickNextTask() {
        // TODO Auto-generated method stub
        int highestPriority = 0;
        for (int i = 1; i < taskQueue.size(); ++i) {
            if (taskQueue.get(i).getPriority() > taskQueue.get(highestPriority).getPriority()) {
                highestPriority = i;
            }
        }
        return taskQueue.remove(highestPriority);
    }
}
