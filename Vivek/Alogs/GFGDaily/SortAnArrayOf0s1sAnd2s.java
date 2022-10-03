import java.util.ArrayList;

/* 
 * 
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.


Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated 
into ascending order.
Example 2:

Input: 
N = 3
arr[] = {0 1 0}
Output:
0 0 1
Explanation:
0s 1s and 2s are segregated 
into ascending order.

Your Task:
You don't need to read input or print anything. Your task is to complete the function sort012() that takes an array arr and N as input parameters and sorts the array in-place.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


 */

public class SortAnArrayOf0s1sAnd2s {

    public static void main(String[] args) {
        int n = 5;
        int arr[] = { 0, 2, 1, 2, 0 };
        sort012(arr, n);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void sort012(int a[], int n) {
        // code here
        int idx_0 = 0, idx_1 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                idx_0++;
            } else if (a[i] == 1) {
                idx_1++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (idx_0 > 0) {
                a[i] = 0;
                idx_0--;
            } else if (idx_1 > 0) {
                a[i] = 1;
                idx_1--;
            } else {
                a[i] = 2;
                ArrayList<Integer> list;
                ArrayList<Integer> temp = temp.addAll(c)
            }
        }
    }
}
