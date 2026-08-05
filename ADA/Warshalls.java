public class Warshalls {
    static final int V = 4;
    void transitiveClosure(int graph[][]) {
        int reach[][] = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                reach[i][j] = graph[i][j];
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    reach[i][j] =
                            (reach[i][j] != 0) ||
                            ((reach[i][k] != 0) && (reach[k][j] != 0))
                            ? 1 : 0;
                }
            }
        }
        printSolution(reach);
    }
    void printSolution(int reach[][]) {
        System.out.println("Transitive Closure of the Graph:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                System.out.print(reach[i][j] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int graph[][] = {
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0},
                {1, 0, 1, 0}
        };
        Warshalls w = new Warshalls();
        w.transitiveClosure(graph);
    }
}
