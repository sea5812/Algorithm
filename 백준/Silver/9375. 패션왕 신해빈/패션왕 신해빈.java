import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            HashMap<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                map.put(s[1], map.getOrDefault(s[1], 0) + 1);
            }
            for (int i : map.values()) {
                cnt *= (i + 1);
            }
            if (n == 0) cnt = 1;
            sb.append(cnt - 1).append("\n");
        }
        System.out.println(sb);
    }
}
