package Alogs.GFGDaily;

import java.util.*;
/* 
Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.

Example 1:

Input:
N = 4
M = 3
E = 5
Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
Output: 1
Explanation: It is possible to colour the
given graph using 3 colours.
Example 2:

Input:
N = 3
M = 2
E = 3
Edges[] = {(0,1),(1,2),(0,2)}
Output: 0
Your Task:
Your task is to complete the function graphColoring() which takes the 2d-array graph[], the number of colours and the number of nodes as inputs and returns true if answer exists otherwise false. 1 is printed if the returned value is true, 0 otherwise. The printing is done by the driver's code.
Note: In Example there are Edges not the graph.Graph will be like, if there is an edge between vertex X and vertex Y graph[] will contain 1 at graph[X-1][Y-1], else 0. In 2d-array graph[ ], nodes are 0-based indexed, i.e. from 0 to N-1.Function will be contain 2-D graph not the edges.

Expected Time Complexity: O(MN).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 20
1 ≤ E ≤ (N*(N-1))/2
1 ≤ M ≤ N
 */
public class MColoringGraph {
        // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    private boolean dfs(Map<Integer,ArrayList<Integer>> map,int currentNode,int[] color,int n,int m){
        if(currentNode == n) {
            return true;
        }
        
        // Check for every color
        for(int currentColor = 1 ; currentColor <= m ; currentColor++) {
            if(safe(currentNode,currentColor,map,color)) {
                color[currentNode] = currentColor;
                
                // Check for the remaining vertices
                if(dfs(map,currentNode + 1,color,n,m)) {
                    return true;
                }
                
                // Backtrace if solution not possible
                color[currentNode] = 0;
            }
        }
        
        return false;
    }
    
    private boolean safe(int currentNode,int currentColor,Map<Integer,ArrayList<Integer>> map,int[] color){
        ArrayList<Integer> arr = map.get(currentNode);
        
        // Check if any neighbour has the current color
        for(int neighbours : arr) {
            if(color[neighbours] == currentColor) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        
        for(int i = 0 ; i < n ; i++) {
            map.put(i,new ArrayList<>());
            for(int j = 0 ; j < n ; j++) {
                if(graph[i][j]) {
                    map.get(i).add(j);
                }
            }
        }
        
        int[] color = new int[n];
        return dfs(map,0,color,n,m);
    }
}
