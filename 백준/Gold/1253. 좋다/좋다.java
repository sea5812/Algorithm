import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).sorted()
            .toArray();

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (left == i || arr[i] > sum ) {
                    left++;
                } else if (right == i || arr[i] < sum) {
                    right--;
                } else {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
