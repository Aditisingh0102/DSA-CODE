import java.util.*;

public class DijkstraAlgorithm {

    private final int V;
    private final List<List<int[]>> graph;

    public DijkstraAlgorithm(int V) {
        this.V = V;
        this.graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            this.graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int w) {
        graph.get(u).add(new int[]{v, w});
        graph.get(v).add(new int[]{u, w});
    }

    public void displayGraph() {
        for (int u = 0; u < graph.size(); u++) {
            System.out.print(u + " : ");
            for (int v = 0; v < graph.get(u).size(); v++) {
                System.out.print("{ " + graph.get(u).get(v)[0] + " , " + graph.get(u).get(v)[1] + " } ");
            }
            System.out.println();
        }
    }

    public void dijkstraAlgorithm(int start) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        boolean[] visited = new boolean[V];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            if (visited[u]) {
                continue;
            }
            visited[u] = true;

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int w = edge[1];
                if (!visited[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        System.out.println("Shortest distances from " + start + ":");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {
        DijkstraAlgorithm obj = new DijkstraAlgorithm(9);

        obj.addEdge(0, 1, 4);
        obj.addEdge(0, 7, 8);
        obj.addEdge(1, 7, 11);
        obj.addEdge(1, 2, 8);
        obj.addEdge(7, 8, 7);
        obj.addEdge(7, 6, 1);
        obj.addEdge(2, 8, 2);
        obj.addEdge(2, 3, 7);
        obj.addEdge(2, 5, 4);
        obj.addEdge(6, 8, 6);
        obj.addEdge(6, 5, 2);
        obj.addEdge(5, 3, 14);
        obj.addEdge(5, 4, 10);
        obj.addEdge(3, 4, 9);

        obj.displayGraph();
        obj.dijkstraAlgorithm(0);
    }
}