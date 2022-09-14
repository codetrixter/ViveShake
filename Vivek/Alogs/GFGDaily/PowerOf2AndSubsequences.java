import java.util.*;


/* 
 * 
Given is an array A[] of size N. Return the number of non-empty subsequences such that the product of all numbers in the subsequence is Power of 2. Since the answer may be too large, return it modulo 109 + 7.

Example 1:

Input:
N = 3
A[] = {1, 6, 2}
Output:
3
Explanation:
The subsequence that 
can be chosen is {1},
{2} and {1,2}.
Example 2:

Input:
N = 3
A[] = {3, 5, 7}
Output:
0
Explanation:
No subsequences exist.
Your Task:

You don't need to read input or print anything. Your task is to complete the function numberOfSubsequences() which takes an integer N and an array A and returns the number of subsequences that exist. As this number can be very large return the result under modulo 109+7.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 * 
 */

public class PowerOf2AndSubsequences {

    public static void main(String[] args) {
        int N = 3;
        ArrayList<Long> A = new ArrayList<>(Arrays.asList(1L, 6L, 2L));
        System.out.println(numberOfSubsequences(N, A));
    }

    static Long numberOfSubsequences(int N, ArrayList<Long> A) {
        // code here
        int count = 0;
        long mod = 1000000007L;
        for (long num : A) {
            if (isPowerOf2(num)) {
                count++;
            }
        }

        return (long) (Math.pow(2, count) % mod - 1) % mod;
    }

    private static boolean isPowerOf2(long num) {
        return (num & (num - 1)) == 0;
    }
}
