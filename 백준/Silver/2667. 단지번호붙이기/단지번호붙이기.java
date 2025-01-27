import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static List<Integer> al = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    al.add(DFS(i, j));
                }
            }
        }
        Collections.sort(al);

        StringBuilder sb = new StringBuilder();
        sb.append(al.size()).append("\n");
        for (int i : al) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static int DFS(int x, int y) {
        visited[x][y] = true;
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny)) {
                cnt += DFS(nx, ny);
            }
        }
        return cnt;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n && !visited[x][y] && board[x][y] == 1;
    }
}
