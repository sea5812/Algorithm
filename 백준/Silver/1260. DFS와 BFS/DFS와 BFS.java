import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited = new boolean[1005];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u - 1).add(v - 1);
            graph.get(v - 1).add(u - 1);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(graph.get(i));
        }

        DFS(graph, visited, start - 1);
        sb.append("\n");
        visited = new boolean[1005];
        BFS(graph, visited, start - 1);

        System.out.println(sb);
    }

    static void DFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int start) {
        visited[start] = true;
        sb.append(start + 1).append(" ");
        for (int i = 0; i < graph.get(start).size(); i++) {
            if (!visited[graph.get(start).get(i)]) {
                DFS(graph, visited, graph.get(start).get(i));
            }
        }
    }

    static void BFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        sb.append(start + 1).append(" ");
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = 0; i < graph.get(u).size(); i++) {
                if (!visited[graph.get(u).get(i)]) {
                    queue.add(graph.get(u).get(i));
                    visited[graph.get(u).get(i)] = true;
                    sb.append(graph.get(u).get(i) + 1).append(" ");
                }
            }
        }
    }
}