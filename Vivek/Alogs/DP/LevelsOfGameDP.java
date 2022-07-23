/* 

You are playing a game. At each level of the game, you have to choose one of the roads to go to the next level. Initially, you have h amount of health and m amount of money.
If you take the first road then your health increases by 3 and money increase by 2. If you take the second road then your health decreases by 5 and money decrease by 10. If you take the third road then health decreases by 20 and money increase by 5.
You have to tell what is the maximum level you can reach up to under the constraints that in no two consecutive levels you can select the same road twice and once your health or money becomes <= 0 game ends(that level is not counted).

Example 1:

Input:
H=2
M=10
Output:
1
Explanation:
For the first level, we can only choose the first road.
Now we cannot move ahead anymore.
Example 2:

Input:
H=20
M=8
Output:
5
Explanation:
Go like this:- R1(23,10)->R3(3,15)->R1(6,17)->
R2(1,7)->R1(4,9)-> game ends as we cannot choose
any more roads.

 */


public class LevelsOfGameDP {

    public static void main(String[] args) {
        System.out.println(maxLevel(2000, 2000));
    }

    public static int maxLevel(int h,int m) {
        // code here
        int[][] dp = new int[3001][3001];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return reachedMaxLevel(dp, h, m, true);
    }
    
    private static int reachedMaxLevel(int[][] dp, int h, int m, boolean ifGotoFirstRoad) {
        
        if(h <= 0 || m <= 0) return -1;
        
        if(dp[h][m] != -1) return dp[h][m];
        
        if(ifGotoFirstRoad) {
            return dp[h][m] = reachedMaxLevel(dp, h+3, m+2, false) + 1;
        } else {
            return dp[h][m] = Math.max(reachedMaxLevel(dp, h-5, m-10, true), reachedMaxLevel(dp, h-20, m+5, true)) + 1;
        } 
    }
    
}
