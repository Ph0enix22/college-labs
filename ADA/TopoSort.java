import java.util.Scanner;
public class TopoSort {
    int n, m, res[], v[], a[][];
    void tsort() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        n = sc.nextInt();
        a = new int[n][n];
        System.out.println("Enter the Adjacency Matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
        v = new int[n];
        res = new int[n];
        m = 0;
        for (int i = 0; i < n; i++)
            if (v[i] == 0)
                dfs(i);
        System.out.print("Topological Sort: ");
        for (int i = n - 1; i >= 0; i--)
            System.out.print(res[i] + " ");
        System.out.println();
    }
    void dfs(int k) {
        v[k] = 1;
        for (int u = 0; u < n; u++)
            if (v[u] == 0 && a[k][u] == 1)
                dfs(u);
        res[m++] = k;
    }
    public static void main(String args[]) {
        TopoSort t = new TopoSort();
        t.tsort();
    }
}
