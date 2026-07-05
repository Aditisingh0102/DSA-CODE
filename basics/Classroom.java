import java.util.*;

public class Classroom {

    public static class Edges {

        private final int src;
        private final int dest;

        public Edges(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void creategraph(ArrayList<Edges> graph[]) {

        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edges(0,1));
        graph[0].add(new Edges(0,2));

        graph[1].add(new Edges(1,0));
        graph[1].add(new Edges(1,3));

        graph[2].add(new Edges(2,0));
        graph[2].add(new Edges(2,4));

        graph[3].add(new Edges(3,1));
        graph[3].add(new Edges(3,4));
        graph[3].add(new Edges(3,5));

        graph[4].add(new Edges(4,2));
        graph[4].add(new Edges(4,3));
        graph[4].add(new Edges(4,5));

        graph[5].add(new Edges(5,3));
        graph[5].add(new Edges(5,4));
        graph[5].add(new Edges(5,6));

        graph[6].add(new Edges(6,5));
    }

    public static void bfs(ArrayList<Edges> graph[]) {

        Queue<Integer> q = new LinkedList<>();

        boolean vis[] = new boolean[graph.length];

        q.add(0);

        while(!q.isEmpty()) {

            int curr = q.remove();

            if(!vis[curr]) {

                System.out.print(curr + " ");

                vis[curr] = true;

                for(int i = 0; i < graph[curr].size(); i++) {

                    Edges e = graph[curr].get(i);

                    q.add(e.dest);
                }
            }
        }
    }



    public static void dfs(ArrayList<Edges> graph[], int curr, boolean vis[]){
        System.out.println(curr + " ");
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edges e = graph[curr].get(i);
            if(!vis[e.dest])
         
                dfs(graph, e.dest, vis);
            
        }
    }
    public void prims(int[][] graph, int start){
        int V = graph.length;
        int[] cost = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        cost[start] = 0;

        for(int i = 0; i < V - 1; i++){
            int u = minCost(cost, visited);
            if(u == -1){
                break;
            }
            visited[u] = true;
            for(int v = 0; v < V; v++){
                if(graph[u][v] != 0 && !visited[v] && graph[u][v] < cost[v]){
                    cost[v] = graph[u][v];
                }
            }
        }
    }

    public int minCost(int[] cost, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int minVertex = -1;
        for(int i = 0; i < cost.length; i++){
            if(!visited[i] && cost[i] < min){
                min = cost[i];
                minVertex = i;
            }
        }
        return minVertex;
    }

public  static void printAllGraph(ArrayList<Edges> graph[], boolean vis[], int curr, String path, int tar){
    if(curr == tar){
        System.out.println(path );
        return;
    }
    for(int i = 0; i < graph[curr].size(); i++){
        Edges e = graph[curr].get(i);
        if(!vis[e.dest]){
            vis[e.dest] = true;
            printAllGraph(graph, vis, e.dest, path +  e.dest, tar);
            vis[e.dest] = false;
        
    
}

    }
}
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edges>[] graph = (ArrayList<Edges>[]) new ArrayList[V];
        creategraph(graph);

        int src = 0;
        int tar = 5;

        printAllGraph(graph, new boolean[V], src, "0", tar);
    }
}

