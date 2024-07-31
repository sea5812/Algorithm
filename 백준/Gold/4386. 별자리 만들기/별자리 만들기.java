import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    private static class Vertex {
        int no;
        double x;
        double y;

        Vertex(int no, double x, double y) {
            this.no = no;
            this.x = x;
            this.y = y;
        }
    }

    private static class Edge implements Comparable<Edge> {
        Vertex u;
        Vertex v;
        double w;

        Edge(Vertex u, Vertex v, double w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Double.compare(this.w, other.w);
        }
    }

    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            double[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            vertices[i] = new Vertex(i, input[0], input[1]);
        }

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Vertex u = vertices[i];
                Vertex v = vertices[j];
                double w = getWeight(u.x, u.y, v.x, v.y);
                edges.add(new Edge(vertices[i], vertices[j], w));
            }
        }

        Collections.sort(edges);

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        double weightSum = 0;
        for (Edge e : edges) {
            if (find(e.u.no) != find(e.v.no)) {
                union(e.u.no, e.v.no);
                weightSum += e.w;
            }
        }
        System.out.printf("%.2f", weightSum);
    }

    private static double getWeight(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static int find(int u) {
        if (parents[u] == u) {
            return u;
        } return parents[u] = find(parents[u]);
    }

    private static void union(int u, int v) {
        if (find(u) != find(v)) {
            parents[find(v)] = find(u);
        }
    }
}
