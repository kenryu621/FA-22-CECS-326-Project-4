# Project 4 - CPU Scheduler

Organization: College of Engineering, California State University Long Beach

Semester: Fall 2022

Course: CECS 326 - Operating System

Author: Diego Garcia and Kenry Yu

Project description: This fourth project involves implementing several different process scheduling algorithms. The scheduler will be assigned a predefined set of tasks and will schedule the tasks based on the selected scheduling algorithm. Each task is assigned a priority and CPU burst. The following scheduling algorithms will be implemented:

- __First-come, first-served__ (FCFS), which schedules tasks in the order in which they request the CPU.
- __Priority scheduling__ (PRI), which schedules tasks based on priority.
- __Round-robin__ (RR), where each task is run for a time quantum (or for the remainder of its CPU burst).

## Instructions

1. To compile and run the program, first ensure you have Java Development Kit (JDK) installed in your operating system.
2. Open the terminal.
3. Git clone the repository `git clone https://github.com/kenryu621/FA-22-CECS-326-Project-4.git`
4. Change your directory to the folder containing the source files using the `cd` command.
    - For example: `cd FA-22-CECS-326-Project-4/`
5. Compile the source files by running `javac CPU_scheduler/*.java` in the terminal. This will compile all of the Java files in the "CPU_scheduler" folder.
6. You should now be able to see `.class` files in the "CPU_Scheduler" folder compiled by the JDK.
7. Run the program by entering the command in the format `java CPU_scheduler.Driver [scheduling algorithm] [tasks file]` in the terminal and observe the outputs. The available scheduling algorithm are `FCFS`, `PRI`, and `RR`.
    - For example:
        - `java CPU_scheduler.Driver FCFS scheduler.txt`
        - `java CPU_scheduler.Driver PRI scheduler.txt`
        - `java CPU_scheduler.Driver RR scheduler.txt`
    - If the terminal prompt `Usage: java Driver <algorithm> <schedule>`, your command line must be wrong. Please try again in the format above.

## Results

The program will display the tasks running in the chosen scheduling algorithm. The output also prompt the task is finished once the burst time is over.
