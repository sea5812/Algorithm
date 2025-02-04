import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int ans = 0;

        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == 'I') {
                int j = 0;
                for (j = 1; j < 2 * n + 1; j++) {
                    if (i + j >= m) break;
                    if (j % 2 == 1 && s.charAt(i + j) == 'O') continue;
                    if (j % 2 == 0 && s.charAt(i + j) == 'I') continue;
                    break;
                }
                if (j == 2 * n + 1) ans++;
            }
        }
        System.out.println(ans);
    }
}
