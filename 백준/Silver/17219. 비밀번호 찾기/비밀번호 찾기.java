import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, String> hm = new HashMap<>();
        while (N-- > 0) {
            input = br.readLine().split(" ");
            hm.put(input[0], input[1]);
        }
        while (M-- > 0) {
            sb.append(hm.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}

