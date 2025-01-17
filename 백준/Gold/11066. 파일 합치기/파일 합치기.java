import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static final int MAX_INT = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] sum = new int[n+1];
            int[][] dp = new int[n+1][n+1];
            st = new StringTokenizer(br.readLine());

            sum[0] = 0;
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n - i; j++) {
                    dp[j][i + j] = MAX_INT;
                    for (int k = j; k < i + j; k++) {
                        dp[j][i + j] = Math.min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + sum[i + j] - sum[j - 1]);
                    }
                }
            }
            System.out.println(dp[1][n]);
        }
    }
}