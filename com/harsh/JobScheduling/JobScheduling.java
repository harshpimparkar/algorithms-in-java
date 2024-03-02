package com.harsh.JobScheduling;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Job {
    char id;
    int deadline;
    int profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobScheduling {

    public static void scheduleJobs(ArrayList<Job> jobs) {
        // Sort jobs based on profit in descending order
        Collections.sort(jobs, Comparator.comparingInt((Job j) -> j.profit).reversed());

        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        char[] result = new char[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];

        for (int i = 0; i < maxDeadline; i++) {
            slot[i] = false;
        }

        for (Job job : jobs) {
            for (int i = Math.min(maxDeadline - 1, job.deadline - 1); i >= 0; i--) {
                if (!slot[i]) {
                    result[i] = job.id;
                    slot[i] = true;
                    break;
                }
            }
        }

        System.out.println("The sequence of jobs scheduled to maximize profit is:");
        for (char job : result) {
            System.out.print(job + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Job> jobs = new ArrayList<>();

        System.out.print("Enter the number of jobs: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for job " + (i + 1) + ":");
            System.out.print("Job ID: ");
            char id = scanner.next().charAt(0);
            System.out.print("Deadline: ");
            int deadline = scanner.nextInt();
            System.out.print("Profit: ");
            int profit = scanner.nextInt();
            jobs.add(new Job(id, deadline, profit));
        }

        scheduleJobs(jobs);

        scanner.close();
    }
}

