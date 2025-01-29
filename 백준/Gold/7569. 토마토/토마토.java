import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] board;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};
    static int n, m, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }
        System.out.println(BFS());
    }

    static int BFS() {
        int day = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            day++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int z = cur[0];
                int x = cur[1];
                int y = cur[2];

                for (int j = 0; j < 6; j++) {
                    int nz = z + dz[j];
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nz >= 0 && nx >= 0 && ny >=0 && nz < h && nx < n && ny < m && board[nz][nx][ny] == 0) {
                        queue.offer(new int[]{nz, nx, ny});
                        board[nz][nx][ny] = 1;
                    }
                }
            }
        }

        for (int[][] z : board) {
            for (int[] x : z) {
                for (int y : x) {
                    if (y == 0) return -1;
                }
            }
        }
        return day;
    }
}
