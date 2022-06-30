public class MatrixChainMultiplication {
    public static void main(String[] args) {
        //given matrix A1(5x4) x A2(4X6) X A3(6X2) X A4(2X7)
        // find the min cost to multiply this matrix
        //d0 = 5, d1 = 4, d2 = 6, d3 = 2, d4 = 7

        int n = 5;
        int P[] = {5,4,6,2,7};
        int m[][] = new int[5][5];
        int s[][] = new int[5][5];

        int j, min, q;

        for(int d = 1; d < n-1; d++) {
            for(int i = 1; i < n-d; i++) {
                j = i+d;
                min = Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    q = m[i][k] + m[k+1][j] + P[i-1]*P[k]*P[j];
                    if(q<min) {
                        min = q;
                        s[i][j] = k;
                    }
                }
                m[i][j] = min;
            }
        }
        System.out.println("Min cost for multiplying given matrix: "+m[1][n-1]);
    }
}
