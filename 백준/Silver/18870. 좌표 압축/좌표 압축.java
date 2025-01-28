import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);

        int idx = 0;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, idx++);
            }
        }

        for (int num : arr) {
            sb.append(map.get(num)).append(" ");
        }
        System.out.println(sb);
    }
}
