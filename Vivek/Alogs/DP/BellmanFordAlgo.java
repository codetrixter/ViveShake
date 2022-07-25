import java.util.Arrays;

/* 
Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: The Graph doesn't contain any negative weight cycle.
 
 If some node isn't possible to visit, then its distance should be 100000000(1e8).

E = [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
S = 2
Output:
1 6 0
Explanation:
For nodes 2 to 0, we can follow the path-
2-0. This has a distance of 1.
For nodes 2 to 1, we cam follow the path-
2-0-1, which has a distance of 1+5 = 6,


E = [[0,1,9]]
S = 0
Output:
0 9
Explanation:
Shortest distance of all nodes from
source is printed.
 */

public class BellmanFordAlgo {

    public static void main(String[] args) {
        // E = [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
        // S = 2
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(new Integer[] { 0, 1, 5 }));
        adj.add(Arrays.asList(new Integer[] { 1, 0, 3 }));
        adj.add(Arrays.asList(new Integer[] { 1, 2, -1 }));
        adj.add(Arrays.asList(new Integer[] { 2, 0, 1 }));
        int V = 3;

        int[] ans = bellman_ford(V, adj, S);

        for (int dis : ans)
            System.out.print(dis + " ");
    }

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S) {
        // Write your code here
        int[] distance = new int[V];

        distance[S] = 0;

        for (int i = 0; i < V; i++) {
            if (i == S)
                continue;
            distance[i] = 100000000;
        }

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < adj.size(); j++) {
                int u = adj.get(j).get(0);
                int v = adj.get(j).get(1);
                int w = adj.get(j).get(2);

                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v])
                    distance[v] = distance[u] + w;
            }
        }

        return distance;
    }
}
