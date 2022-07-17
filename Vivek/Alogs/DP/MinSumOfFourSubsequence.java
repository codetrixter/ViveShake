import java.util.Arrays;

public class MinSumOfFourSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int n = 8;
        System.out.println(getMinSumOfFourSubsequence(arr, n));//ans: 6
    }
    
    private static int getMinSumOfFourSubsequence(int [] arr,  int n){

        if(n <= 4)
            return Arrays.stream(arr).min().getAsInt();
        
        int sum[] = new int[n];

        sum[0] = arr[0];
        sum[1] = arr[1];
        sum[2] = arr[2];
        sum[3] = arr[3];

        for(int i = 4; i < n; i++) {
            sum[i] = arr[i] + Math.min(
                    Math.min(sum[i-1], sum[i-2]), Math.min(sum[i-3], sum[i-4])
                );
        }

        return Arrays.stream(Arrays.copyOfRange(sum, n-4, n)).min().getAsInt();
    }
}
