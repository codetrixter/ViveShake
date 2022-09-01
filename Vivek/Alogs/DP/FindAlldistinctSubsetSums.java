import java.util.*;

/* 

Given a set of integers, find all distinct sums that can be generated from the subsets of the given sets.
 

Example 1:

Input: nums = {1,2}
Output: {0,1,2,3}
Explanation: Four distinct sums can be
calculated which are 0, 1, 2 and 3.
0 if we do not choose any number.
1 if we choose only 1.
2 if we choose only 2.
3 if we choose 1 and 2.

Example 2:

Input: nums = {1,2,3}
Output: {0,1,2,3,4,5,6}
Explanation: Seven distinct sum can be calculated
which are 0, 1, 2, 3, 4, 5 and 6.
0 if we do not choose any number.
1 if we choose only 1.
2 if we choose only 2.
3 if we choose only 3.
4 if we choose 1 and 3.
5 if we choose 2 and 3.
6 if we choose 1, 2 and 3.

 

Your Task:
You don't need to read or print anything. Your task is to complete the function DistinictSum() which takes nums as input parameter and returns a list containing the distinict sum in increasing order,
 

Expected Time Complexity: O(n * sum) where sum = sum of all elements of nums.
Expected Space Complexity: O(n * sum)
 

Constraints:
1 <= length of nums <= 102
1 <= nums[i] <= 102

 */

public class FindAlldistinctSubsetSums {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        for (int i : new FindAlldistinctSubsetSums().DistinctSum(nums)) {
            System.out.print(" " + i);
        }
    }

    public int[] DistinctSum(int[] nums) {
        // Code here
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            Set<Integer> setTemp = new HashSet<>();

            for (Integer num : set) {
                setTemp.add(num);// adding origin num 0, 1
                setTemp.add(num + nums[i]);// adding new num in set
            }
            setTemp.add(nums[i]);
            set = setTemp;
        }
        int n = set.size();
        int k = 0;
        int arr[] = new int[n];
        for (int num : set) {
            arr[k++] = num;
        }

        Arrays.sort(arr);
        return arr;
    }
}
