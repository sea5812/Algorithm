import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited = new boolean[100001];
    static int n, k, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }
        BFS();
        System.out.println(ans);
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int x = q.poll();
                int[] arr = new int[]{x - 1, x + 1, 2 * x};

                for (int y : arr) {
                    if (y >= 0 && y <= 100000 && !visited[y]) {
                        q.offer(y);
                        visited[y] = true;
                        if (y == k) {
                            return;
                        }
                    }
                }
            }
        }
    }
}
