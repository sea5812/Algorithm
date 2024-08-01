import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    private static String[] input;
    private static List<List<Node>> adjList;
    private static int[] dist;
    private static boolean[] visited;
    private static int V, E, K;
    private final static int INF = Integer.MAX_VALUE;

    private static class Node implements Comparable<Node> {
        int v, w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node other) {
            return this.w - other.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        dist = new int[V+1];
        visited = new boolean[V+1];
        Arrays.fill(dist, INF);

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            adjList.get(u-1).add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
                }
        }
        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            visited[current.v] = true;
            for (Node next : adjList.get(current.v-1)) {
                if (!visited[next.v] && dist[current.v] != INF && dist[current.v] + next.w < dist[next.v]) {
                    dist[next.v] = dist[current.v] + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}

