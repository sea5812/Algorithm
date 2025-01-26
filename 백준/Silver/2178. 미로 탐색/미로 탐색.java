import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[][] distance;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        BFS();
        System.out.println(distance[n - 1][m - 1]);
    }

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        distance[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny)) {
                    q.offer(new int[]{nx, ny});
                    distance[nx][ny] = distance[x][y] + 1;

                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 1 && distance[x][y] == 0;
    }
}
