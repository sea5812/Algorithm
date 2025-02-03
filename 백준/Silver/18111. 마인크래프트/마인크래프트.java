import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int n, m, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;
        for (int k = 0; k <= 256; k++) {
            int t = 0;
            int blocks = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (k > board[i][j]) {
                        t += (k - board[i][j]);
                        blocks -= (k - board[i][j]);
                    } else if (k < board[i][j]) {
                        t += 2 * (board[i][j] - k);
                        blocks += (board[i][j] - k);
                    }
                }
            }
            if (blocks >= 0 && time >= t) {
                time = t;
                height = k;
            }
        }
        System.out.println(time + " " + height);
    }
}
