package CPU_scheduler;

/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 */

import java.util.*;

// Your code here
public class RR implements Algorithm {

    private int RRindex;
    private List<Task> taskQueue;

    public RR(List<Task> queue) {
        this.RRindex = 0;
        this.taskQueue = queue;
    }

    @Override
    public void schedule() {
        // TODO Auto-generated method stub
        while (taskQueue.size() != 0) {
            Task nextTask = pickNextTask();
            CPU.run(nextTask, 10);
            if (nextTask.getBurst() <= 10) {
                System.out.println("Task " + nextTask.getName() + " finished.\n");
                taskQueue.remove(taskQueue.indexOf(nextTask));
                if (taskQueue.size() != 0 && RRindex > 0)
                    --RRindex;
            } else {
                nextTask.setBurst(nextTask.getBurst() - 10);
            }
        }
    }

    @Override
    public Task pickNextTask() {
        // TODO Auto-generated method stub
        Task upcomingTask = taskQueue.get(RRindex);
        RRindex = ++RRindex % taskQueue.size();
        return upcomingTask;
    }
}