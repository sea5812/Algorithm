import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int white, blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void func(int x, int y, int n) {
        if (n == 1) {
            if (board[x][y] == 0) white++;
            else blue++;
            return;
        }
        boolean whiteFlag = true;
        boolean blueFlag = true;
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[i][j] == 0) blueFlag = false;
                if (board[i][j] == 1) whiteFlag = false;
            }
        }
        if (whiteFlag) {
            white++;
        } else if (blueFlag) {
            blue++;
        } else {
            func(x, y, n / 2);
            func(x + n / 2, y, n / 2);
            func(x, y + n / 2, n / 2);
            func(x + n / 2, y + n / 2, n / 2);
        }
    }
}
