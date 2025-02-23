import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[] s1 = new char[n];
            char[] originS1 = new char[n];
            char[] s2 = new char[n];
            char[] originS2 = new char[n];

            String input = br.readLine();
            for (int i = 0; i < n; i++) {
                s1[i] = input.charAt(i);
                originS1[i] = s1[i];
            }
            input = br.readLine();
            for (int i = 0; i < n; i++) {
                s2[i] = input.charAt(i);
                originS2[i] = s2[i];
            }
            char[] target = new char[2 * n];
            input = br.readLine();
            for (int i = 0; i < 2 * n; i++) {
                target[i] = input.charAt(i);
            }

            int cnt = 0;
            while (true) {
                char[] s = new char[2 * n];
                for (int i = 0; i < n; i++) {
                    s[i * 2] = s2[i];
                    s[i * 2 + 1] = s1[i];
                }
                cnt++;
                if (Arrays.equals(s, target)) {
                    sb.append(cnt).append("\n");
                    break;
                }

                for (int i = 0; i < n; i++) {
                    s1[i] = s[i];
                    s2[i] = s[i + n];
                }

                if (Arrays.equals(s1, originS1) && Arrays.equals(s2, originS2)) {
                    sb.append(-1).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}