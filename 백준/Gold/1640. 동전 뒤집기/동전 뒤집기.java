import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static final int MAX_INT = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        int[] row = new int[2];
        int[] col = new int[2];
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) k++;
            }
            if (k % 2 == 1) row[0]++;
            else row[1]++;
        }
        for (int j = 0; j < m; j++) {
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i][j] == 1) k++;
            }
            if (k % 2 == 1) col[0]++;
            else col[1]++;
        }

        int ans1 = 0;
        int r0, r1, c0, c1;
        r0 = row[0]; r1 = row[1]; c0 = col[0]; c1 = col[1];
        ans1 += r0;
        r1 += r0;
        r0 = 0;
        if (ans1 % 2 == 1) {
            int tmp = c0;
            c0 = c1;
            c1 = tmp;
        }
        if (c0 % 2 == 0) ans1 += c0;
        else ans1 = -1;

        int ans2 = 0;
        r0 = row[0]; r1 = row[1]; c0 = col[0]; c1 = col[1];
        ans2 += r1;
        r0 += r1;
        r1 = 0;
        if (ans2 % 2 == 1) {
            int tmp = c0;
            c0 = c1;
            c1 = tmp;
        }
        if (c0 % 2 == 1) ans2 += c0;
        else ans2 = -1;

        if (ans1 == -1 && ans2 == -1) System.out.println(-1);
        else if (ans1 == -1) System.out.println(ans2);
        else if (ans2 == -1) System.out.println(ans1);
        else System.out.println(Math.min(ans1, ans2));
    }
}