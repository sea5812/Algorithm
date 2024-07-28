import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) max = arr[i];
            sum += arr[i];
        }
        double ans = ((double) sum / n) / max * 100;

        System.out.println(ans);
        br.close();
    }
}
