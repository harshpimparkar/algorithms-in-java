package com.harsh.RoundRobinOS;
import java.util.*;

class Process {
    int id;
    int arrivalTime;
    int burstTime;
    int remainingTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;

    Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class RoundRobinScheduling {
    public static void roundRobin(Process[] processes, int n, int timeQuantum) {
        int currentTime = 0;
        int completedProcesses = 0;
        int waitingTime = 0;
        int turnaroundTime = 0;
        int[] timeSlice = new int[n];

        for (int i = 0; i < n; i++) {
            timeSlice[i] = timeQuantum;
        }

        System.out.println("Process\tAT\tBT\tCT\tTAT\tWT");
        while (completedProcesses < n) {
            for (int i = 0; i < n; i++) {
                if (processes[i].remainingTime > 0) {
                    if (processes[i].remainingTime > timeQuantum) {
                        currentTime += timeQuantum;
                        processes[i].remainingTime -= timeQuantum;
                    } else {
                        currentTime += processes[i].remainingTime;
                        processes[i].completionTime = currentTime;
                        waitingTime += currentTime - processes[i].arrivalTime - processes[i].burstTime;
                        turnaroundTime += currentTime - processes[i].arrivalTime;
                        processes[i].remainingTime = 0;
                        completedProcesses++;

                        System.out.println(processes[i].id + "\t" + processes[i].arrivalTime + "\t"
                                + processes[i].burstTime + "\t" + processes[i].completionTime + "\t"
                                + (currentTime - processes[i].arrivalTime) + "\t"
                                + (currentTime - processes[i].arrivalTime - processes[i].burstTime));
                    }
                }
            }
        }

        System.out.println("Average Waiting Time: " + (float) waitingTime / n);
        System.out.println("Average Turnaround Time: " + (float) turnaroundTime / n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();
        Process[] processes = new Process[n];

        System.out.print("Enter time quantum: ");
        int timeQuantum = scanner.nextInt();

        System.out.println("Enter arrival time and burst time for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + (i + 1) + ": ");
            int arrivalTime = scanner.nextInt();
            int burstTime = scanner.nextInt();
            processes[i] = new Process(i + 1, arrivalTime, burstTime);
        }

        roundRobin(processes, n, timeQuantum);

        scanner.close();
    }
}
