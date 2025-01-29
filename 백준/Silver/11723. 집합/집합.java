import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (query) {
                case "add" -> set.add(x);
                case "remove" -> set.remove(x);
                case "check" -> sb.append(set.contains(x) ? 1 : 0).append("\n");
                case "toggle" -> {
                    if (set.contains(x)) {
                        set.remove(x);
                    } else {
                        set.add(x);
                    }
                }
                case "all" -> {
                    for (int i = 1; i <= 20; i++) {
                        set.add(i);
                    }
                }
                case "empty" -> set.clear();
            }
        }
        System.out.println(sb);
    }
}
