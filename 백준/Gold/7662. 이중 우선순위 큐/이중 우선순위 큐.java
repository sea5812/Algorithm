import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (c == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (!map.isEmpty()){
                    int key = n == 1 ? map.lastKey() : map.firstKey();
                    int cnt = map.get(key);
                    if (cnt == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, cnt - 1);
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
