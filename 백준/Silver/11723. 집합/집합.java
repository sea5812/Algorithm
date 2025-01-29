import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int bitmask = 0;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }
            switch (query) {
                case "add" -> bitmask |= 1 << (x - 1);
                case "remove" -> bitmask &= ~(1 << (x - 1));
                case "check" -> sb.append((bitmask & (1 << (x - 1))) != 0 ? 1 : 0).append("\n");
                case "toggle" -> bitmask ^= (1 << (x - 1));
                case "all" -> bitmask = (1 << 20) - 1;
                case "empty" -> bitmask = 0;
            }
        }
        System.out.println(sb);
    }
}
