import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(BFS(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    static class Register {
        int n;
        String s;

        Register(int n, String s) {
            this.n = n;
            this.s = s;
        }
    }

    static String BFS(int a, int b) {
        boolean[] visited = new boolean[10000];
        Queue<Register> q = new LinkedList<>();
        q.add(new Register(a, ""));
        visited[a] = true;
        while (!q.isEmpty()) {
            Register cur = q.poll();
            Register[] DSLR = new Register[]{D(cur), S(cur), L(cur), R(cur)};
            for (Register next : DSLR) {
                if (!visited[next.n]) {
                    if (next.n == b) {
                        return next.s;
                    }
                    q.add(next);
                    visited[next.n] = true;
                }
            }
        }
        return "";
    }

    static Register D(Register r) {
        return new Register((r.n * 2) % 10000, r.s + "D");
    }

    static Register S(Register r) {
        int next = (r.n == 0) ? 9999 : r.n - 1;
        return new Register(next, r.s + "S");
    }

    static Register L(Register r) {
        int a = r.n / 1000;
        int b = (r.n / 100) % 10;
        int c = (r.n / 10) % 10;
        int d = r.n % 10;
        return new Register((b * 1000 + c * 100 + d * 10 + a), r.s + "L");
    }

    static Register R(Register r) {
        int a = r.n / 1000;
        int b = (r.n / 100) % 10;
        int c = (r.n / 10) % 10;
        int d = r.n % 10;
        return new Register((d * 1000 + a * 100 + b * 10 + c), r.s + "R");
    }

}
