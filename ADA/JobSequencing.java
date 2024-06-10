import java.util.*;

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

public class JobSequencing {
    
    public static void printJobSequence(Job[] jobs) {
        // Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        
        int maxDeadline = Arrays.stream(jobs).mapToInt(job -> job.deadline).max().getAsInt();
        
        boolean[] slot = new boolean[maxDeadline + 1];
        char[] result = new char[maxDeadline + 1];
        
        for (int i = 0; i < jobs.length; i++) {
            for (int j = Math.min(maxDeadline, jobs[i].deadline); j > 0; j--) {
                if (!slot[j]) {
                    result[j] = jobs[i].id;
                    slot[j] = true;
                    break;
                }
            }
        }
        
        System.out.println("Job sequence:");
        for (char ch : result) {
            if (ch != '\0') {
                System.out.print(ch + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job('a', 2, 100),
            new Job('b', 1, 19),
            new Job('c', 2, 27),
            new Job('d', 1, 25),
            new Job('e', 3, 15)
        };

        System.out.println("Given jobs:");
        for (Job job : jobs) {
            System.out.println("Job ID: " + job.id + ", Deadline: " + job.deadline + ", Profit: " + job.profit);
        }

        printJobSequence(jobs);
    }
}
