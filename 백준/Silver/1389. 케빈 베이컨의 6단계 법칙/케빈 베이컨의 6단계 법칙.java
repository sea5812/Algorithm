import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] dist;
    static int[] num;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for (int i = 1; i <= n; i++) {
            dist = new int[n + 1];
            Arrays.fill(dist, -1);
            num[i] = BFS(i);
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (min > num[i]) {
                min = num[i];
                ans = i;
            }
        }
        System.out.println(ans);
    }

    static int BFS(int i) {
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        dist[i] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if (dist[v] == -1) {
                    q.add(v);
                    dist[v] = dist[u] + 1;
                }
            }
        }
        for (int j = 1; j <= n; j++) {
            sum += dist[j];
        }
        return sum;
    }
}
