import java.util.*;

/* 

Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].

Example 1:

Input:
m = 6, n = 6
arr1[] = {1,2,3,4,7,9}
arr2[] = {0,1,2,1,1,4}
Output: 4 5 5 6 6 6
Explanation: Number of elements less than
or equal to 1, 2, 3, 4, 7, and 9 in the
second array are respectively 4,5,5,6,6,6
Example 2:

Input:
m = 5, n = 7
arr1[] = {4,8,7,5,1}
arr2[] = {4,48,3,0,1,1,5}
Output: 5 6 6 6 3
Your Task :
Complete the function countEleLessThanOrEqual() that takes two array arr1[], arr2[],  m, and n as input and returns an array containing the required results(the count of elements less than or equal to it in arr2 for each element in arr1 where ith output represents the count for ith element in arr1.)

Expected Time Complexity: O((m + n) * log n).
Expected Auxiliary Space: O(1).

Constraints:
1<=m,n<=10^5
1<=arr1[i],arr2[j]<=10^5

 */

public class CountingElementsInTwoArrays {

    private static void printAns(ArrayList<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 7, 9 };
        int arr2[] = { 0, 1, 2, 1, 1, 4 };

        printAns(countEleLessThanOrEqual(arr1, arr2, 6, 6));

        int arr3[] = { 4, 8, 7, 5, 1 };
        int arr4[] = { 4, 48, 3, 0, 1, 1, 5 };
        printAns(countEleLessThanOrEqual(arr3, arr4, 5, 7));
    }

    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n) {

        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr2);
        for (int i = 0; i < m; i++) {
            list.add(findSmaller(arr1[i], arr2));
        }

        return list;
    }

    private static int findSmaller(int key, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int count = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= key) {
                count = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return count + 1;
    }
}
