import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static int[] input;
    private static ArrayList<Integer>[] adjList;
    private static int[] visited;
    private static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        adjList = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            adjList[input[0]].add(input[1]);
            adjList[input[1]].add(input[0]);
        }

        visited = new int[n+1];
        dfs(1);
        System.out.println(cnt);
    }
    private static void dfs(int start) {
        visited[start] = 1;
        for (int next : adjList[start]) {
            if (visited[next] == 0) {
                cnt++;
                dfs(next);
            }
        }
    }
}
