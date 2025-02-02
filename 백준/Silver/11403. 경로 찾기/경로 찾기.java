import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            visited = new int[n];
            DFS(i);
            for (int j = 0; j < n; j++) {
                sb.append(visited[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int i) {
        for (int next : graph.get(i)) {
            if (visited[next] == 0) {
                visited[next] = 1;
                DFS(next);
            }
        }
    }
}
