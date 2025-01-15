import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int r, c;
    static Stack<int[]>[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        S = new Stack[c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < c; i++) {
            S[i] = new Stack<>();
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            stoneMove(k - 1);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean isOutOfBoard(int row, int col) {
        return row < 0 || row >= r || col < 0 || col >= c;
    }

    static void stoneMove(int col) {
        if (S[col].isEmpty()) {
            S[col].push(new int[]{0, col});
        }

        while (true) {
            int[] cur = S[col].peek();
            int i = cur[0];
            int j = cur[1];

            if (board[i][j] == 'O') {
                S[col].pop();
                if (S[col].isEmpty()) {
                    S[col].push(new int[]{0, col});
                }
                continue;
            }

            if (i + 1 == r || board[i + 1][j] == 'X') {
                board[i][j] = 'O';
                return;
            } else if (board[i + 1][j] == '.') {
                i++;
                S[col].push(new int[]{i, j});
            } else {
                if (!isOutOfBoard(i + 1, j - 1) && board[i][j - 1] == '.' && board[i + 1][j - 1] == '.') {
                    i++; j--;
                    S[col].push(new int[]{i, j});
                } else if (!isOutOfBoard(i + 1, j + 1) && board[i][j + 1] == '.' && board[i + 1][j + 1] == '.') {
                    i++; j++;
                    S[col].push(new int[]{i, j});
                } else {
                    board[i][j] = 'O';
                    return;
                }
            }
        }
    }

}
