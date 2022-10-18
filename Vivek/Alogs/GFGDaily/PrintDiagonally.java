import java.util.ArrayList;

/* 
Give a N * N square matrix A, return all the elements of its anti-diagonals from top to bottom.

Example 1:

Input: 
N = 2
A = [[1, 2],
     [3, 4]]
Output:
1 2 3 4
Explanation: 

Hence, elements will be returned in the 
order {1, 2, 3, 4}.
Example 2:

Input: 
N = 3 
A = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
Output: 
1 2 4 3 5 7 6 8 9
Explanation: 

Hence, elements will be returned in 
the order {1, 2, 4, 3, 5, 7, 6, 8, 9}.

Your Task:
You don't need to read input or print anything. Your task is to complete the function 
downwardDigonal() which takes an integer N and a 2D matrix A[ ][ ] as input parameters 
and returns the list of all elements of its anti-diagonals from top to bottom.

Expected Time Complexity: O(N*N)
Expected Auxillary Space: O(N*N)

Constraints:
1 ≤ N, M ≤ 103
0 ≤ A[i][j] ≤ 106
 */
public class PrintDiagonally {

    public static void main(String[] args) {
        int N = 3;
        int[][] A = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        downwardDigonal(N, A).forEach(s -> System.out.println(s));

    };

    static ArrayListist<Integer> downwardDigonal(int N, int A[][]) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            for (int i = 0; i <= j; i++) {
                // System.out.println(i+","+j);
                res.add(A[i][j - i]);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = N - 1; j >= i; j--) {
                res.add(A[N - 1 - j + i][j]);
            }
        }

        return res;
    }
}
