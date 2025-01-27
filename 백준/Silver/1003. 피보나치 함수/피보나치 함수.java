import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new int[41][2];
        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};
        dp[2] = new int[]{1, 1};
        for (int i = 3; i < 41; i++) {
            dp[i] = new int[]{dp[i-1][0] + dp[i-2][0], dp[i-1][1] + dp[i-2][1]};
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
