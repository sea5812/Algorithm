import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap<Integer, String> hm1 = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            hm1.put(i, name);
            hm2.put(name, i);
        }

        for (int i = 1; i <= M; i++) {
            String query = br.readLine();
            if (isNumeric(query)) {
                int number = Integer.parseInt(query);
                sb.append(hm1.get(number)).append("\n");
            } else {
                sb.append(hm2.get(query)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

