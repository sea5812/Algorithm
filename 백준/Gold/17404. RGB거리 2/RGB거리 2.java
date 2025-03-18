import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static int[][] arr;
    static int[][] dp;
    static int n, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            int min = Integer.MAX_VALUE;
            dp = new int[n][3];
            if (i == 0) {
                dp[1][0] = 2001;
                dp[1][1] = arr[0][0] + arr[1][1];
                dp[1][2] = arr[0][0] + arr[1][2];
            } else if (i == 1) {
                dp[1][0] = arr[0][1] + arr[1][0];
                dp[1][1] = 2001;
                dp[1][2] = arr[0][1] + arr[1][2];
            } else {
                dp[1][0] = arr[0][2] + arr[1][0];
                dp[1][1] = arr[0][2] + arr[1][1];
                dp[1][2] = 2001;
            }
            for (int j = 2; j < n; j++) {
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + arr[j][2];
            }
            for (int k = 0; k < 3; k++) {
                if (k == i) continue;
                min = Math.min(min, dp[n-1][k]);
            }
            ans = Math.min(ans, min);
        }
        System.out.println(ans);
    }
}
