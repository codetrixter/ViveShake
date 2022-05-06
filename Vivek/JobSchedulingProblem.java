import java.util.Arrays;
import java.util.Comparator;

public class JobSchedulingProblem {

    static Comparator<Job> comparator = new Comparator<Job>() {
        public int compare(Job a, Job b) {
            return b.profit - a.profit;
        }
    };
    
    public static void main(String args []) {
        Job[] jobs = getJobs();
        printJobs(jobs);
        int profit = getMaxProfit(jobs);
        printJobs(jobs);
        System.out.println("max profit: "+profit);
        //output:
        //(100, 2) (19, 2) (40, 2) (15, 2) (50, 1)
        //(100, 2) (50, 1) (40, 2) (19, 2) (15, 2)
        //max profit: 150
    }

    private static int getMaxProfit(Job[] jobs) {
        Arrays.sort(jobs, comparator);//job sorted
        int result = 0;
        int[] arr = new int [jobs.length];

        for(int i = 0; i < jobs.length; i++) {// take each job with max profit
            for(int j = jobs[i].deadline-1; j >= 0; j--) {// start putting job latest deadline
                if(arr[j] != 1) {
                    arr[j] = 1;
                    result += jobs[i].profit;
                    break;
                }
            }
        }
        return result;
    }

    private static Job[] getJobs() {
        Job j1 = new Job(1, 100, 2);
        Job j2 = new Job(2, 19, 2);
        Job j3 = new Job(3, 40, 2);
        Job j4 = new Job(4, 15, 2);
        Job j5 = new Job(5, 50, 1);
        Job[] jobs = {j1,j2,j3,j4,j5};
        return jobs;
    }

    private static void printJobs(Job[] jobs) {
        for(Job j : jobs) {
            System.out.print(" ("+j.profit + ", "+j.deadline+")");
        }
        System.out.println();
    }
}

class Job {
    int id;
    int profit;
    int deadline;

    public Job(int id, int profit, int deadline) {
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }
}
