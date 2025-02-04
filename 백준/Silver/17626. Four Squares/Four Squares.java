import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                System.out.println(1);
                return;
            }
        }

        for (int i = 1; i * i <= n; i++) {
            for (int j = 1; j * j <= n - i * i; j++) {
                if (i * i + j * j == n) {
                    System.out.println(2);
                    return;
                }
            }
        }

        for (int i = 1; i * i <= n; i++) {
            for (int j = 1; j * j <= n - i * i; j++) {
                for (int k = 1; k * k <= n - i * i - j * j; k++) {
                    if (i * i + j * j + k * k == n) {
                        System.out.println(3);
                        return;
                    }
                }
            }
        }
        System.out.println(4);
    }
}
