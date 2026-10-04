import java.io.*;
import java.util.*;

public class Solution {

    static int V;
    static long[][] capacity;
    static long[][] flow;

    // Finds an augmenting path using BFS
    static long bfs(int source, int sink, int[] parent) {
        Arrays.fill(parent, -1);
        parent[source] = source;

        long[] pathFlow = new long[V];
        pathFlow[source] = Long.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {

                // Residual capacity exists
                long residual = capacity[u][v] - flow[u][v];

                if (parent[v] == -1 && residual > 0) {
                    parent[v] = u;
                    pathFlow[v] = Math.min(pathFlow[u], residual);

                    if (v == sink) {
                        return pathFlow[v];
                    }

                    queue.offer(v);
                }
            }
        }

        return 0;
    }

    static long fordFulkerson(int source, int sink) {
        long maxFlow = 0;
        int[] parent = new int[V];

        while (true) {
            long pathFlow = bfs(source, sink, parent);

            if (pathFlow == 0) {
                break;
            }

            maxFlow += pathFlow;

            int v = sink;

            while (v != source) {
                int u = parent[v];

                // Add flow in forward direction
                flow[u][v] += pathFlow;

                // Subtract flow in reverse direction
                flow[v][u] -= pathFlow;

                v = u;
            }
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        int E = sc.nextInt();

        capacity = new long[V][V];
        flow = new long[V][V];

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long c = sc.nextLong();

            capacity[u][v] += c;
        }

        int source = 0;
        int sink = V - 1;

        System.out.println(fordFulkerson(source, sink));

        sc.close();
    }
}
