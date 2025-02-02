import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st  = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                initVisited(i, j);
                ans = Math.max(ans, BFS(i, j));
            }
        }
        System.out.println(ans);
    }

    static class Vertex implements Comparable<Vertex> {
        int x, y, cnt;
        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
            cnt = board[x][y];
        }

        @Override
        public int compareTo(Vertex o) {
            return o.cnt - cnt;
        }
    }

    static void initVisited(int x, int y) {
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (x + i >= 0 && y + j >= 0 && x + i < n && y + j < m) {
                    visited[x + i][y + j] = false;
                }
            }
        }
    }

    static int BFS(int r, int c) {
        int sum = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        visited[r][c] = true;
        sum += board[r][c];

        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i], ny = c + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                pq.offer(new Vertex(nx, ny));
                visited[nx][ny] = true;
            }
        }
        Vertex u = pq.poll();
        Vertex v = pq.poll();
        sum += u.cnt + v.cnt;
        offer(pq, u);
        offer(pq, v);
        sum += pq.poll().cnt;

        return sum;
    }

    static void offer(PriorityQueue<Vertex> pq, Vertex v) {
        for (int i = 0; i < 4; i++) {
            int nx = v.x + dx[i], ny = v.y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                pq.offer(new Vertex(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}
