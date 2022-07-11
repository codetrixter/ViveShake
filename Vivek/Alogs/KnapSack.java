package Alogs;

public class KnapSack {
    public static void main(String[] args) {
        int P[] = {0, 1, 2, 5, 6};
        int wt[] = {0, 2, 3, 4, 5};
        int m = 8, n = 4;

        int k [][] = new int[5][9];

        for(int i = 0; i <= n; i++) {
            for(int w = 0; w <= m; w++) {
                if(i == 0 || w == 0) {
                    k[i][w] = 0;
                } else if(wt[i] <= w) {
                    k[i][w] = Math.max(P[i] + k[i-1][w-wt[i]], k[i-1][w]);
                } else {
                    k[i][w] = k[i-1][w];
                }
            }
        }
        System.out.println(k[n][m]);
    }
}
