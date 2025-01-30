import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().replaceAll("[\\[\\]]", "").split(",");
            Deque<Integer> deque = new ArrayDeque<>();
            int reverse = 0;
            boolean error = false;
            for (int i = 0; i < n; i++) {
                deque.offerLast(Integer.parseInt(input[i]));
            }
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    reverse = 1 - reverse;
                } else if (p.charAt(i) == 'D' && !deque.isEmpty()) {
                    if (reverse == 0) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                } else {
                    sb.append("error").append("\n");
                    error = true;
                    break;
                }
            }
            int size = deque.size();
            if (!error) {
                sb.append("[");
                if (reverse == 0) {
                    for (int i = 0; i < size; i++) {
                        sb.append(deque.pollFirst()).append(",");
                    }
                } else {
                    for (int i = 0; i < size; i++) {
                        sb.append(deque.pollLast()).append(",");
                    }
                }
                if (sb.charAt(sb.length() - 1) == ',') sb.deleteCharAt(sb.length() - 1);
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}
