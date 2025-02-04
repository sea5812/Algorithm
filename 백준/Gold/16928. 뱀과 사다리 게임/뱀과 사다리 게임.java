import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] ladder = new int[101];
    static int[] dist = new int[101];
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder[x] = y;
        }

        Arrays.fill(dist, -1);
        BFS();
        System.out.println(dist[100]);
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) continue;
                if (ladder[cur + i] != 0) {
                    next = ladder[next];
                }
                if (dist[next] == -1) {
                    q.offer(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }
    }
}
