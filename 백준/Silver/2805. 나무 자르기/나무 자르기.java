import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(bSearch(0, arr[n - 1]));
    }

    static int bSearch(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            long tree = getTree(mid);

            if (tree >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    static long getTree(int x) {
        long tree = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > x) tree += arr[i] - x;
        }
        return tree;
    }
}
