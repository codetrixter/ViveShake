package Alogs.DP;

/* 
Given N friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
Note: Since answer can be very large, return your answer mod 10^9+7.


Example 1:

Input:N = 3
Output: 4
Explanation:
{1}, {2}, {3} : All single
{1}, {2,3} : 2 and 3 paired but 1 is single.
{1,2}, {3} : 1 and 2 are paired but 3 is single.
{1,3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1,2} and {2,1} are considered same.
Example 2: 

Input: N = 2
Output: 2
Explanation:
{1} , {2} : All single.
{1,2} : 1 and 2 are paired.

Your Task:
You don't need to read input or print anything. Your task is to complete the function countFriendsPairings() which accepts an integer n and return number of ways in which friends can remain single or can be paired up.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 104
 */

public class PairOfFriends {

    public static void main(String[] args) {
        PairOfFriends pf = new PairOfFriends();
        System.out.println(pf.countFriendsPairings(3));
    }

    public long countFriendsPairings(int n) {
        if (n <= 2)
            return n;
        long mod = (long) Math.pow(10, 9) + 7;
        long secPrev = 1;
        long prev = 2;
        long curr = 0;
        for (int i = 3; i <= n; i++) {
            curr = (prev % mod + (i - 1) % mod * secPrev % mod) % mod;
            secPrev = prev;
            prev = curr;
        }

        return curr;
    }
}
