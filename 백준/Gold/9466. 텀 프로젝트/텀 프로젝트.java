import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static ArrayList<Integer>[] adjList;
    private static int[] visit;
    private static int[] hasCycle;
    private static final int UNVISITED = 0;
    private static final int VISITING = 1;
    private static final int VISITED = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .map(i -> i - 1)
                    .toArray();

            adjList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjList[i] = new ArrayList<>();
                adjList[i].add(input[i]);
            }

            visit = new int[n];
            hasCycle = new int[n];
            //init
            Arrays.fill(visit, UNVISITED);
            Arrays.fill(hasCycle, 0);

            for (int i = 0; i < n; i++) {
                if (visit[i] == UNVISITED) {
                    dfs(i);
                }
            }

            long cnt = Arrays.stream(hasCycle)
                    .filter(cycle -> cycle == 0)
                    .count();
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int start) {
        visit[start] = VISITING;
        int next = adjList[start].get(0);

        if (visit[next] == UNVISITED) {
            dfs(next);
        } else if (visit[next] == VISITING) {
            hasCycle[start] = 1;
            for (int current = next; current != start; current = adjList[current].get(0)) {
                hasCycle[current] = 1;
            }
        }
        visit[start] = VISITED;
    }
}
