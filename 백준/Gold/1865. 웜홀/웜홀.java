import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static int[] input;
    private static int[] dist;
    private static ArrayList<Edge> edges;
    private static int N, M, W;
    private static final int INF = 100000;

    private static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            N = input[0];
            M = input[1];
            W = input[2];

            dist = new int[N+1];
            Arrays.fill(dist, INF);

            edges = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
                edges.add(new Edge(input[0], input[1], input[2]));
                edges.add(new Edge(input[1], input[0], input[2]));
            }
            for (int i = 0; i < W; i++) {
                input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
                edges.add(new Edge(input[0], input[1], -input[2]));
            }
            for (int i = 1; i <= N; i++) {
                if (hasNegativeCycle(i)) {
                    System.out.println("YES");
                    break;
                }
                if (i == N) System.out.println("NO");
            }
        }
    }
    private static boolean hasNegativeCycle(int start) {
        dist[start] = 0;
        for (int i = 0; i < N - 1; i++) {
            boolean updated = false;
            for (Edge e : edges) {
                if (dist[e.u] != INF && dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                    updated = true;
                }
            }
            if (!updated) break;
        }
        for (Edge e : edges) {
            if (dist[e.u] != INF && dist[e.u] + e.w < dist[e.v]) {
                return true;
            }
        }
        return false;
    }
}
