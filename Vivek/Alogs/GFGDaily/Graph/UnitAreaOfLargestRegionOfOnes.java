package Alogs.GFGDaily.Graph;

/* 
Given a grid of dimension nxm containing 0s and 1s. Find the unit area of the largest region of 1s.
Region of 1's is a group of 1's connected 8-directionally (horizontally, vertically, diagonally).
 

Example 1:

Input: grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}}
Output: 5
Explanation: The grid is-
1 1 1 0
0 0 1 0
0 0 0 1
The largest region of 1's is colored
in orange.
Example 2:

Input: grid = {{0,1}}
Output: 1
Explanation: The grid is-
0 1
The largest region of 1's is colored in 
orange.

Your Task:
You don't need to read or print anyhting. Your task is to complete the function findMaxArea() which takes grid as input parameter and returns the area of the largest region of 1's.


Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)
 

Constraints:
1 ≤ n, m ≤ 500
 */

public class UnitAreaOfLargestRegionOfOnes {
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

    public static void main(String[] args) {
        int grid [][] = {{1,1,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(new UnitAreaOfLargestRegionOfOnes().findMaxArea(grid));
    }


    public int findMaxArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    int[] count = { 0 };
                    dfs(grid, i, j, count);
                    ans = Math.max(ans, count[0]);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int x, int y, int[] count) {
        if (grid[x][y] == 0)
            return;
        int m = grid.length, n = grid[0].length;
        grid[x][y] = 0;
        count[0] += 1;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                dfs(grid, nx, ny, count);
            }
        }
    }
}
