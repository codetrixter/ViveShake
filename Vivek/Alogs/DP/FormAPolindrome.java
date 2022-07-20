/* 

Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
For Example:
ab: Number of insertions required is 1. bab or aba
aa: Number of insertions required is 0. aa
abcd: Number of insertions required is 3. dcbabcd

 */


 /* 

Input: str = "abcd"
Output: 3
Explanation: Inserted character marked
with bold characters in dcbabcd

Input: str = "aa"
Output: 0
Explanation:"aa" is already a palindrome.

  */

public class FormAPolindrome {
    
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(countMin(str));
        String str2 = "geeks";
        System.out.println(countMin(str2));  
        String str3 = "abcba";
        System.out.println(countMin(str3));
    }

    static int countMin(String str)
    {
        // code here
        int dp[][]  = new int[1001][1001];
        for(int i = 0; i < 1001; i++) {
            for(int j = 0; j < 1001; j++) {
                dp[i][j] = -1;
            }
        }
        return getMin(0, str.length() - 1, str, dp);
    }
    
    private static int getMin(int l, int h, String str, int[][] dp) {
        if(l >= h) return 0;
        
        if(dp[l][h] != -1) return dp[l][h];
        
        if(str.charAt(l) == str.charAt(h))
            return dp[l][h] = getMin(l+1, h-1, str, dp);
        
        return dp[l][h] = Math.min(getMin(l+1, h, str, dp), getMin(l, h-1, str, dp)) + 1;
    }
}
