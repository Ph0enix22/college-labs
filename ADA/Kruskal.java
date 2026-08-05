import java.util.Scanner;
public class Kruskal {
    int n, c[][], st[][], par[];
    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();
        c = new int[n+1][n+1];
        par = new int[n+1];
        System.out.println("Enter the Cost Adjacency Matrix:");
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                c[i][j] = sc.nextInt();
        for (int i = 1; i <= n; i++)
            par[i] = i;
        sc.close();
    }
    int find(int i) {
        return par[i];
    }
    void unions(int i, int j) {
        par[j] = i;
    }
    void algo() {
        int  a, b, min, minCost = 0, e = 0, u = 0, v = 0;
        st = new int[n+1][n+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                st[i][j] = c[i][j];
        System.out.println("Minimum Cost Spanning Tree:");
        while (e != n-1) {
            min = 999;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (min > st[i][j]) {
                        min = st[i][j];
                        u = i;
                        v = j;
                    }
                }
            }
            st[u][v] = 999;
            a = find(u);
            b = find(v);
            if (a != b) {
                e++;
                System.out.println(e + ": " + u + " -> " + v + "  Cost = " + min);
                unions(a, b);
                minCost += min;
            } else {
                System.out.println(u + " -> " + v + " Rejected (Forms a Cycle)");
            }
        }
        System.out.println("Minimum Cost = " + minCost);
    }
    public static void main(String[] args) {
        Kruskal k = new Kruskal();
        k.read();
        k.algo();
    }
}
