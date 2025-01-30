import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, r, c, cnt, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        int size = (int) Math.pow(2, n);
        func(0, 0, size);
        System.out.println(ans);
    }

    static void func(int x, int y, int size) {
        if (size == 1) {
            ans = cnt;
            return;
        }
        int s = size / 2;
        if (r < x + s && c < y + s) {
            func(x, y, s);
        } else if (r < x + s && c >= y + s) {
            cnt += s * s;
            func(x, y + s, s);
        }else if (r >= x + s && c < y + s) {
            cnt += 2 * s * s;
            func(x + s, y, s);
        } else {
            cnt += 3 * s * s;
            func(x + s, y + s, s);
        }
    }
}
