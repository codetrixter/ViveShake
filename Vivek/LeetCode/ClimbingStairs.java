package LeetCode;
/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
/* 
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
*/

/* 
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println("ways for 10 steps: "+climbingStairsWays(10));
        System.out.println("ways for 45 steps: "+climbingStairsWays(45));
        System.out.println("ways for 2 steps: "+climbingStairsWays(2));
        System.out.println("ways for 3 steps: "+climbingStairsWays(3));
    }
    /* 
    output:
    ways for 10 steps: 89
    ways for 45 steps: 1836311903
    ways for 2 steps: 2
    ways for 3 steps: 3
     */

    private static int climbingStairsWays(int steps) {
        int one = 1, two = 1;
        
        for (int i = 0; i < steps-1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        
        return one;
    }
}
