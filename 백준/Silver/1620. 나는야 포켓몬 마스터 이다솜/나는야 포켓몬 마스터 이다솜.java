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

        String[] numberToString = new String[N + 1];
        HashMap<String, Integer> stringToNumber = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            numberToString[i] = name;
            stringToNumber.put(name, i);
        }

        for (int i = 1; i <= M; i++) {
            String query = br.readLine();
            if (isNumeric(query)) {
                int number = Integer.parseInt(query);
                sb.append(numberToString[number]).append("\n");
            } else {
                sb.append(stringToNumber.get(query)).append("\n");
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

