import java.util.*;

public class Topological {
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

        graph.get(2).add(new Edge(2, 3));
        graph.get(3).add(new Edge(3, 1));
        graph.get(4).add(new Edge(4, 0));
        graph.get(4).add(new Edge(4, 1));
        graph.get(5).add(new Edge(5, 0));
        graph.get(5).add(new Edge(5, 2));
    }

    public static void topSortUtil(List<List<Edge>> graph, int curr, boolean[] vis, Stack<Integer> stack) {
        vis[curr] = true;

        for (int i = 0; i < graph.get(curr).size(); i++) {
            Edge e = graph.get(curr).get(i);

            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static void topSort(List<List<Edge>> graph, int V) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        createGraph(graph);
        topSort(graph, V);
    }
}
