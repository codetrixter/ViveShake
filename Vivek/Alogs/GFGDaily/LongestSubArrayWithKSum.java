package Alogs.GFGDaily;

import java.util.HashMap;

/* 
Given an array containing N integers and an integer K., Your task is to find the length of the 
longest Sub-Array with the sum of the elements equal to the given value K.

 

Example 1:
 

Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.
Example 2:

Input : 
A[] = {-1, 2, 3}
K = 6
Output : 0
Explanation: 
There is no such sub-array with sum 6.
Your Task:
This is a function problem. The input is already taken care of by the driver code.
You only need to complete the function smallestSubsegment() that takes an array (A),
sizeOfArray (n),  sum (K)and returns the required length of the longest Sub-Array. 
The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1<=N<=105
-105<=A[i], K<=105
 
 */


 public class LongestSubArrayWithKSum {

    public static void main(String[] args) {
        int A[] = {10, 5, 2, 7, 1, 9};
        System.out.println(lenOfLongSubarr(A, 6, 15));

        int B[] = {-1, 2, 3};
        System.out.println(lenOfLongSubarr(B, 3, 6));
    }

    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Complete the function
        HashMap<Integer, Integer> h = new HashMap<>();
        int presum = 0;
        int res = 0;
        for (int i = 0; i < N; i++) {
            presum += A[i];
            if (presum == K) {
                res = i + 1;
            }
            if (!h.containsKey(presum)) {
                h.put(presum, i);
            }
            if (h.containsKey(presum - K)) {
                res = Math.max(res, i - h.get(presum - K));
            }
        }
        return res;
    }
}
