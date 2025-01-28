import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int cnt = 0;

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        while (N-- > 0) {
            set.add(br.readLine());
        }
        while (M-- > 0) {
            String s = br.readLine();
            if (set.contains(s)) {
                cnt++;
                list.add(s);
            }
        }
        Collections.sort(list);
        sb.append(cnt).append("\n");
        for (String p : list) {
            sb.append(p).append("\n");
        }
        System.out.println(sb);
    }
}

