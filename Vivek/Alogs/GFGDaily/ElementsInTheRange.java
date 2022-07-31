/* 
Given an array arr[] containing positive elements. A and B are two numbers defining a range. The task is to check if the array contains all elements in the given range.

Example 1:

Input: N = 7, A = 2, B = 5
arr[] =  {1, 4, 5, 2, 7, 8, 3}
Output: Yes
Explanation: It has elements between 
range 2-5 i.e 2,3,4,5
Example 2:

Input: N = 7, A = 2, B = 6
arr[] = {1, 4, 5, 2, 7, 8, 3}
Output: No
Explanation: Array does not contain 6.
 */

public class ElementsInTheRange {

    public static void main(String[] args) {
        int arr[] = { 1, 4, 5, 2, 7, 8, 3 };
        System.out.println(check_elements(arr, 7, 2, 5));// true
        System.out.println(check_elements(arr, 7, 2, 6));// false

    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(B-A+1)
     */
    private static boolean check_elements(int arr[], int n, int A, int B) {
        int k = B - A + 1;
        int[] trackList = new int[k];

        for (int i = 0; i < n; i++) {
            if (arr[i] - A >= 0 && arr[i] - A < k) {
                trackList[arr[i] - A] = 1;
            }
        }

        for (int i = 0; i < k; i++) {
            if (trackList[i] == 0)
                return false;
        }

        return true;
    }
}
