import java.util.*;

/* 

Given a graph with V vertices. We say two vertices u and v belong to a single province 
if there is a path from u to v or v to u. Your task is to find the number of provinces.
Note: A province is a group of directly or indirectly connected cities and no other cities 
outside of the group.

Input:
[
 [1, 0, 1],
 [0, 1, 0],
 [1, 0, 1]
]

Output:
2
Explanation:
The graph clearly has 2 Provinces [1,3] and [2]. 
As city 1 and city 3 has a path between them they 
belong to a single province. City 2 has no path 
to city 1 or city 3 hence it belongs to another 
province.


Example 2:
Input:
[
 [1, 1],
 [1, 1]
]

Output :
1

 */

public class NumberOfProvinces {

    public static void main(String[] args) {
        // Integer[][] arr = new Integer[][]{ {1,0,1},
        // {0,1,0},
        // {1,0,1}
        // };
        List<List<Integer>> adj = new ArrayList<>();
        Integer[] a1 = { 1, 0, 1 };
        List<Integer> adj1 = Arrays.asList(a1);

        Integer[] a2 = { 0, 1, 0 };
        List<Integer> adj2 = Arrays.asList(a2);

        Integer[] a3 = { 1, 0, 1 };
        List<Integer> adj3 = Arrays.asList(a3);

        adj.add(adj1);
        adj.add(adj2);
        adj.add(adj3);

        int V = 3;

        System.out.println(numProvinces(adj, V));
    }

    static int numProvinces(List<List<Integer>> adj, int V) {
        // code here
        int count = 0;
        boolean[] visited = new boolean[V];

        for (int i = 0; i < adj.get(0).size(); i++) {
            if (visited[i])
                continue;
            count++;
            def(i, visited, adj);
        }

        return count;
    }

    private static void def(int i, boolean[] visited, List<List<Integer>> adj) {

        if (visited[i])
            return;

        visited[i] = true;

        List<Integer> nbList = new ArrayList<>();

        List<Integer> tempList = adj.get(i);

        for (int j = 0; j < tempList.size(); j++) {

            if (visited[j])
                continue;

            if (tempList.get(j) == 1 && j != i) {
                nbList.add(j);
            }
        }

        for (int x : nbList) {
            def(x, visited, adj);
        }

    }
}
