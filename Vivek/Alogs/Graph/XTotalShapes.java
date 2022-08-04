/* 
Given  a grid of n*m consisting of O's and X's. The task is to find the number of 'X' total shapes.
Note: 'X' shape consists of one or more adjacent X's (diagonals not included).
 

Example 1:

Input: grid = {{X,O,X},{O,X,O},{X,X,X}}
Output: 3
Explanation: 
The grid is-
X O X
O X O
X X X
So, X with same colour are adjacent to each 
other vertically for horizontally (diagonals 
not included). So, there are 3 different groups 
in the given grid.

Example 2:

Input: grid = {{X,X},{X,X}}
Output: 1
Expanation: 
The grid is- 
X X
X X
So, X with same colour are adjacent to each
other vertically for horizontally (diagonals
not included). So, there is only 1 group
in the given grid.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function xShape() which takes grid as input parameter and returns the count of total X shapes.
 

Expected Time Compelxity: O(n*m)
Expected Space Compelxity: O(n*m)
 */

public class XTotalShapes {
    
    public static void main(String[] args) {
        XTotalShapes shapes = new XTotalShapes();
        char[][] grid = {{'X','O','X'},{'O','X','O'},{'X','X','X'}};
        System.out.println(shapes.xShape(grid));//ans 3 
        char[][] grid2 =  {{'X','X'},{'X','X'}};
        System.out.println(shapes.xShape(grid2));//ans 1
    }

    public int xShape(char[][] grid) {
        // code here
        int count = 0;
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(visited[i][j] || grid[i][j] == 'O') continue;
                dfs(i,j, visited, grid);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(int i, int j, boolean[][] visited, char[][] grid) {
        //if(visited[i][j]) return;
        visited[i][j] = true;
        int[] dx = {0 , -1, 0, 1};
        int[] dy = {-1,  0, 1, 0};
        //check neighbors
        for(int x = 0; x < dx.length; x++) {
            int p = i+dx[x];
            int q = j+dy[x];
            if(isNotInRange(p,q, grid) || grid[p][q] == 'O' || visited[p][q]){
                continue;
            }
            dfs(p,q,visited,grid);
        }
    }
    
    private boolean isNotInRange(int p, int q, char[][] grid) {
        return p < 0 || p >= grid.length || q < 0 || q >= grid[0].length;
    }
}
