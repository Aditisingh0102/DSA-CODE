public class tree{
    static int[][] dist = new int[][]{
    {0, 9, 12, 3},
    {4, 0, 5, 10},
    {1, 4, 0, 2},
    {3, 7, 6, 0}
    };
    static final int n = dist.length;
    public static int minCostPath(int mask, int pos){
        if(mask == ((1 << n) - 1)) return dist[pos][1];
        int ans = Integer.MAX_VALUE;
        for(int city = 0; city < n; city++){
            if((mask & (1 << city)) == 0){
                int pathCost = dist[pos][city]  + minCostPath(mask | (1 << city), city);
                if(pathCost < ans) ans = pathCost;
            }
        }
        return ans;
    }
     public static void main(String[] args){
        System.out.println(minCostPath(1, 0));
    }
}
