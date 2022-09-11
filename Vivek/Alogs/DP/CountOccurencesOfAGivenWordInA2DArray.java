/* 
 * 
Find the number of occurrences of a given search word in  a 2d-Array of characters where the word can go up, down, left, right and around 90 degree bends.


Example 1:

Input: 
R = 4, C = 5
mat = {{S,N,B,S,N},
       {B,A,K,E,A},
       {B,K,B,B,K},
       {S,E,B,S,E}}
target = SNAKES
Output:
3
Explanation: 
S N B S N
B A K E A
B K B B K
S E B S E
Total occurrence of the word is 3
and denoted by color.
Example 2:

Input:
R = 3, C = 3 
mat = {{c,a,t},
       {a,t,c},
       {c,t,a}}
target = cat
Output:
5
Explanation: Same explanation
as first example.

Your task:
You dont need to read input or print anything. Your task is to complete the function findOccurrence() which takes the mat contaning N*M 2-d array of character and target as input parameters and returns thethe number of occurrences of target.


Expected Time Complexity: O(R*C*22*len), Where len is length of target String.
Expected Auxiliary Space: O(1)


 */

public class CountOccurencesOfAGivenWordInA2DArray {
    int ans;

    public static void main(String[] args) {
        char[][] mat = { { 'S', 'N', 'B', 'S', 'N' },
                { 'B', 'A', 'K', 'E', 'A' },
                { 'B', 'K', 'B', 'B', 'K' },
                { 'S', 'E', 'B', 'S', 'E' } };

        String target = "SNAKES";

        char[][] mat1 = { { 'c', 'a', 't' },
                { 'a', 't', 'c' },
                { 'c', 't', 'a' } };
        String target1 = "cat";

        CountOccurencesOfAGivenWordInA2DArray obj = new CountOccurencesOfAGivenWordInA2DArray();

        System.out.println(obj.findOccurrence(mat, target));
        System.out.println(obj.findOccurrence(mat1, target1));
    }

    public int findOccurrence(char mat[][], String target) {
        ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                dfs(mat, i, j, 0, target);
            }
        }
        return ans;
    }

    private void dfs(char[][] mat, int i, int j, int idx, String target) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length ||
                idx >= target.length() || mat[i][j] != target.charAt(idx))
            return;

        if (idx == target.length() - 1) {
            ans++;
            return;
        }
        char c = mat[i][j];
        mat[i][j] = '0';
        dfs(mat, i, j + 1, idx + 1, target);
        dfs(mat, i, j - 1, idx + 1, target);
        dfs(mat, i + 1, j, idx + 1, target);
        dfs(mat, i - 1, j, idx + 1, target);
        mat[i][j] = c;
    }
}
