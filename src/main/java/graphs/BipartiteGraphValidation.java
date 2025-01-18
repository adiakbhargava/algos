package graphs;

public class BipartiteGraphValidation {
    public static void main(String[] args) {
        int[][] graph = {
                {1,4},
                {0,2},
                {1},
                {4},
                {0,3}
        };
        System.out.println((new BipartiteGraphValidation()).bipartiteGraphValidation(graph));

        int[][] graph1 = {
                {1,4},
                {0,4},
                {1,3},
                {4,2},
                {0,3}
        };
        System.out.println((new BipartiteGraphValidation()).bipartiteGraphValidation(graph1));
    }

    private boolean bipartiteGraphValidation(int[][] graph){
        int[] colors = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(colors[i] == 0 && !dfs(i, 1, graph, colors)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int color, int[][] graph, int[] colors){
        colors[node] = color;
        for(int neighbor : graph[node]){
            if(colors[neighbor] == color){
                return false;
            }

            if(colors[neighbor] == 0 && !dfs(neighbor, -1*color, graph, colors)){
                return false;
            }
        }

        return true;
    }
}
