import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) % k != 0) System.out.println(i);
        }
    }
}