import java.util.*;

public class CycleInGraph {
    public static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }

        @Override
        public String toString() {
            return src + " -> " + dest;
        }
    }

    public static void createGraph(List<List<Edge>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            graph.set(i, new ArrayList<>());
        }

        graph.get(0).add(new Edge(0, 1));
        graph.get(0).add(new Edge(0, 4));

        graph.get(1).add(new Edge(1, 0));
        graph.get(1).add(new Edge(1, 2));
        graph.get(1).add(new Edge(1, 4));

        graph.get(2).add(new Edge(2, 1));
        graph.get(2).add(new Edge(2, 3));

        graph.get(3).add(new Edge(3, 2));

        graph.get(4).add(new Edge(4, 0));
        graph.get(4).add(new Edge(4, 1));
        graph.get(4).add(new Edge(4, 5));

        graph.get(5).add(new Edge(5, 4));
    }

    public static boolean isCycleUndirected(List<List<Edge>> graph, boolean[] vis, int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph.get(curr).size(); i++) {
            Edge e = graph.get(curr).get(i);
            if (vis[e.dest] && e.dest != par) {
                return true;
            } else if (!vis[e.dest]) {
                if (isCycleUndirected(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        createGraph(graph);

        System.out.println(isCycleUndirected(graph, new boolean[V], 0, -1));
    }
}
