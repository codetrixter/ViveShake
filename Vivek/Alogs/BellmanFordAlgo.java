package Alogs;

public class BellmanFordAlgo {
    private static int[] dis;

    public static void main(String[] args) {
        //edge list, where edge is {from, to, weight}

        //1st test case
        int ver1 = 3;
        int[][] edges1 = {{0,1,-1}, {1,2,-2}, {2,0,-3}};
        bellmanFordAlgo(ver1, edges1);
        if(isNegativeCycle(edges1)) {
            System.out.println("Negative cycle found!!!");
        } else {
            for(int i = 0; i < dis.length; i++) {
                System.out.println("0 to "+i + " -> "+dis[i]);
            }
        }

        //2nd test case
        int ver2 = 7;
        int[][] edges2 = {{0,1,6}, {0,2,5}, {0,3,5},
        {1,4,-1}, {2,1,-2},{2,4,1}, {3,2,-2}, 
        {3,5,-1}, {4,6,3}, {5,6,3}};
        bellmanFordAlgo(ver2, edges2);
        if(isNegativeCycle(edges2)) {
            System.out.println("Negative cycle found!!!");
        } else {
            for(int i = 0; i < dis.length; i++) {
                System.out.println("0 to "+i + " -> "+dis[i]);
            }
        }
    }
    
    private static void bellmanFordAlgo(int vertices, int[][] edges) {
        dis = new int[vertices];
        dis[0] = 0;
        for(int i = 1; i < vertices; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < vertices-1; i++) {
            //relax the edges 
            for(int[] edge : edges) {
                int u = edge[0];//from
                int v = edge[1];//to
                int weight = edge[2];
                if(dis[u] != Integer.MAX_VALUE && (dis[v] > (dis[u] + weight))) {
                    System.out.println(dis[v] + " : "+(dis[u]+weight));
                    dis[v] = dis[u] + weight;
                }
            }
        }
    }

    private static boolean isNegativeCycle(int[][] edges) {
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if(dis[u] != Integer.MAX_VALUE && (dis[v] > (dis[u] + weight))) {
                return true;
            }
        }
        return false;
    }
}
