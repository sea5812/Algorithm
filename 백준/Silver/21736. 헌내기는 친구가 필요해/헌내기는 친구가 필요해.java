import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m, x, y, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'I') {
                    x = i; y = j;
                }
            }
        }
        DFS(x, y);
        if (ans == 0) {
            System.out.println("TT");
        } else {
            System.out.println(ans);
        }
    }

    static void DFS(int r, int c) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && board[nx][ny] != 'X') {
                if (board[nx][ny] == 'P') ans++;
                DFS(nx, ny);
            }
        }
    }
}
