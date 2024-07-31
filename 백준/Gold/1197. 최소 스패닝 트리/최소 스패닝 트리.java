import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge other) {
            return this.w - other.w;
        }
    }

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] VE = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int V = VE[0];
        int E = VE[1];

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            edges[i] = new Edge(input[0] - 1, input[1] - 1, input[2]);
        }

        Arrays.sort(edges);

        parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int mstWeight = 0;
        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                mstWeight += e.w;
            }
        }
        System.out.println(mstWeight);
    }

    private static int find(int u) {
        if (parent[u] == u) {
            return u;
        }
        return parent[u] = find(parent[u]);
    }

    private static void union(int u, int v) {
        if (find(u) != find(v)) {
            parent[find(v)] = find(u);
        }
    }
}
