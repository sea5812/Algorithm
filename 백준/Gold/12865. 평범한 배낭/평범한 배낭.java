import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] input;
    private static int[] weight;
    private static int[] value;
    private static int[][] dp;
    private static int n;
    private static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        n = input[0];
        k = input[1];

        weight = new int[n+1];
        value = new int[n+1];
        for (int i = 1; i <= n; i++) {
            input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            weight[i] = input[0];
            value[i] = input[1];
        }

        dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            int w = weight[i];
            int v = value[i];
            for (int j = 1; j <= k; j++) {
                if (j - w >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
