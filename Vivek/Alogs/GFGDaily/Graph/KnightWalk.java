package Alogs.GFGDaily.Graph;
import java.util.*;
/* 
Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.If it cannot reach the target position return -1.

Note:
The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.

Example 1:

Input:
N=6
knightPos[ ] = {4, 5}
targetPos[ ] = {1, 1}
Output:
3
Explanation:

Knight takes 3 step to reach from
(4, 5) to (1, 1):
(4, 5) -> (5, 3) -> (3, 2) -> (1, 1). 

Example 2:

Input:
N=8
knightPos[ ] = {7, 7}
targetPos[ ] = {1, 5}
Output:
4
Explanation:
Knight takes 4 steps to reach from
(7, 7) to (1, 5):
(4, 5) -> (6, 5) -> (5, 3) -> (7, 2) -> (1, 5).
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function minStepToReachTarget() which takes the inital position of Knight (KnightPos), the target position of Knight (TargetPos) and the size of the chess board (N) as an input parameters and returns the minimum number of steps required by the knight to reach from its current position to the given target position.If it cannot reach the target position return -1.

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N2).

Constraints:
1 <= N <= 1000
1 <= Knight_pos(X, Y), Targer_pos(X, Y) <= N
 */
public class KnightWalk {
    int currLayer = 0;
    int nextLayer = 0;
    int [] dx = {1, 1, -1, -1, 2, -2, 2, -2};
    int [] dy = {-2, 2, -2, 2, -1, -1, 1, 1};

    int startXY, endXY;
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        startXY = 0;
        endXY = N-1;
        int Kx = KnightPos[0] - 1, Ky = KnightPos[1] - 1;
        int Tx = TargetPos[0] - 1,  Ty = TargetPos[1] - 1;
        int step = 0;
        Queue<Integer> queX = new LinkedList<>();
        Queue<Integer> queY = new LinkedList<>();
        queX.add(Kx);
        queY.add(Ky);
        currLayer = 1;
        nextLayer = 0;
        return getTarget(Tx, Ty, step, queX, queY);
    }
    
    private int getTarget(int Tx, int Ty, int step, Queue<Integer> queX, Queue<Integer> queY) {
        
        while(!queX.isEmpty()) {
            int Kx = queX.remove();
            int Ky = queY.remove();
            currLayer--;
            if(Kx == Tx && Ky == Ty) return step;
            
            for(int i = 0; i< dx.length; i++) {
                int x = Kx + dx[i];
                int y = Ky + dy[i];
                
                if(isInRange(x,y)) {
                    queX.add(x);
                    queY.add(y);
                    nextLayer++;
                }
            }
            
            if(currLayer == 0) {
                step++;
                currLayer = nextLayer;
                nextLayer =0;
            }
            
        }
        
        return -1;
    }
    
    private boolean isInRange(int x, int y) {
        return x >= startXY && x <= endXY &&  y >= startXY && y <= endXY;
    }
}
