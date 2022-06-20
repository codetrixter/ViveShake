package LeetCode;
/* 
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. 
Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
 */


public class ClimbingStairsMinCost {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        int result = minCostClimbingStairs(cost);
        System.out.println("output: result: "+result);
        /* 
         * output: result: 15
         */
    }

    public static int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int second = 0;
        int first = cost[size-1];
        
        for(int i = size-2; i >= 0; i--) {
            int temp = first;
            first = Math.min(first + cost[i], second + cost[i]);
            second = temp;
        }
        
        return Math.min(first, second);
    }
}
