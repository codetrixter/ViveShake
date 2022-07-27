/* 

M hooks are present in a straight line on wall A and N hooks are present in a straight line on wall B. Each hook on wall A is connected to each hooks on wall B by ropes. K ropes must be used to make the desired giant knot. How many such knots can Geek make ?
Note: 2 knots are considered to be the same if they involve the same hooks. 


Example 1:

Input:
M = 3, N = 2, K = 2
Output: 3
Explaination: 
hooks on Wall A are A1 A2 A3.
hooks on wall B are B1 B2. 

Joining 
 A1  A2  A3
 |       |
 B1      B2

is same as joining 
 A1  A2  A3
 |       |
 B2      B1 
because the two groups involve the same hooks. 
But the groups (A1-B1, A3-B2), (A1-B1, A2-B2), 
(A2-B1, A3-B2) are all different.  

 */

public class GeeksAndKnots {

    private static int mod = 1000000007;

    public static void main(String[] args) {
        System.out.println(knots(3, 2, 2));
    }

    static int knots(int M, int N, int K) {
        // code here
        long[][] comb = new long[Math.max(M, N) + 1][Math.max(M, N) + 1];
        for (int i = 0; i <= Math.max(M, N); i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++)
                comb[i][j] = ((comb[i - 1][j] % mod) + (comb[i - 1][j - 1] % mod)) % mod;
        }

        int ans = (int) (comb[N][K] * comb[M][K]) % mod;

        return ans;
    }
}
