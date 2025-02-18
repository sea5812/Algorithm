import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1000;
    static int[][] lines;
    static int[][] dist;
    static boolean[] isPrime = new boolean[1000001];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Arrays.fill(isPrime, Boolean.TRUE);
        for (int i = 2; i * i < 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int cnt = BFS(n, a, b);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static int BFS(int n, int a, int b) {
        int[] dist = new int[1000001];
        Arrays.fill(dist, -1);
        dist[n] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (a <= cur && cur <= b && isPrime[cur]) return dist[cur];

            int[] next = new int[]{cur / 2, cur / 3, cur + 1, cur - 1};
            for (int i : next) {
                if (i >= 2 && i <= 1000000 && dist[i] == -1) {
                    q.offer(i);
                    dist[i] = dist[cur] + 1;
                }
            }
        }
        return -1;
    }
}