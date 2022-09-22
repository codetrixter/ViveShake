import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/* 
Due to the rise of covid-19 cases in India, this year BCCI decided to organize knock-out matches in IPL rather than a league.

Today is matchday 2 and it is between the most loved team Chennai Super Kings and the most underrated team - Punjab Kings. Stephen Fleming, the head coach of CSK, analyzing the batting stats of Punjab. He has stats of runs scored by all N players in the previous season and he wants to find the maximum score for each and every contiguous sub-list of size K to strategize for the game.

Example 1:

Input:
N = 9, K = 3
arr[] = 1 2 3 1 4 5 2 3 6
Output: 
3 3 4 5 5 5 6 
Explanation: 
1st contiguous subarray = {1 2 3} Max = 3
2nd contiguous subarray = {2 3 1} Max = 3
3rd contiguous subarray = {3 1 4} Max = 4
4th contiguous subarray = {1 4 5} Max = 5
5th contiguous subarray = {4 5 2} Max = 5
6th contiguous subarray = {5 2 3} Max = 5
7th contiguous subarray = {2 3 6} Max = 6
Example 2:

Input:
N = 10, K = 4
arr[] = 8 5 10 7 9 4 15 12 90 13
Output: 
10 10 10 15 15 90 90
Explanation: 
1st contiguous subarray = {8 5 10 7}, Max = 10
2nd contiguous subarray = {5 10 7 9}, Max = 10 
3rd contiguous subarray = {10 7 9 4}, Max = 10 
4th contiguous subarray = {7 9 4 15}, Max = 15
5th contiguous subarray = {9 4 15 12}, Max = 15 
6th contiguous subarray = {4 15 12 90}, Max = 90 
7th contiguous subarray = {15 12 90 13}, Max = 90 

Your Task:  
You don't need to read input or print anything. Complete the function max_of_subarrays() which takes the array, N, and K as input parameters and returns a list of integers denoting the maximum of every contiguous subarray of size K.

Constraints:
1 ≤ N ≤ 106
1 ≤ K ≤ N
0 ≤ arr[i] ≤ 106
 */

public class IPL2021MatchDay2 {

    // second approach optimized
    static ArrayList<Integer> max_of_subarrays2(int arr[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            while (!dq.isEmpty() && i - dq.peekFirst() >= k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.removeLast();
            }
            dq.addLast(i);

            if (i >= k - 1)
                ans.add(arr[dq.peekFirst()]);
        }

        return ans;
    }

    // first approach TLE
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = k - 1;

        if (arr.length < k) {
            list.add(getMax(0, arr.length - 1, arr));
        } else {
            PriorityQueue<Integer> pq = new PriorityQueue<>(k, (p, q) -> {
                if (p == q)
                    return 0;
                else if (p < q)
                    return 1;
                else
                    return -1;

            });

            for (int y = 0; y < k; y++) {
                pq.add(arr[y]);
            }

            list.add(pq.peek());
            i++;
            j++;

            for (int x = j; x < n; x++, i++) {
                pq.remove(arr[i - 1]);
                pq.add(arr[x]);
                list.add(pq.peek());
            }
        }

        return list;
    }

    private static int getMax(int i, int j, int arr[]) {
        int max = 0;
        for (int k = i; k <= j; k++) {
            if (arr[k] > max)
                max = arr[k];
        }
        return max;
    }
}
