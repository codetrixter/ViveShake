public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));// ans 4
    }

    public static int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];

        // Taking last index element only we will get 1 length of LIS for sure
        lis[nums.length - 1] = 1;

        // Check from i = last second index till 0:
        // if i is less than element at j, which is right to it then it will form LIS(i)
        // = LIS(j) + 1
        // update only if the LIS(i) is greater than previously saved LIS(i)
        for (int i = nums.length - 2; i >= 0; i--) {
            lis[i] = 1;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int ans : lis) {
            if (ans > max) {
                max = ans;
            }
        }
        return max;
    }
}
