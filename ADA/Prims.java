import java.util.Scanner;
public class Prims {
    int n, c[][], st[][];
    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();
        c = new int[n+1][n+1];
        System.out.println("Enter the Cost Adjacency Matrix:");
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                c[i][j] = sc.nextInt();
        sc.close();
    }
    void primsAlg() {
        st = new int[n+1][3];
        int nr[] = new int[n+1];
        int i, j, w, u = 0, min, minCost = 0;
        for (i = 1; i <= n; i++)
            nr[i] = 1;
        nr[1] = 0;
        for (i = 1; i < n; i++) {
            min = 999;
            for (j = 1; j <= n; j++) {
                if (nr[j] != 0 && c[j][nr[j]] < min) {
                    min = c[j][nr[j]];
                    u = j;
                }
            }
            st[i][1] = u;
            st[i][2] = nr[u];
            minCost += c[u][nr[u]];
            nr[u] = 0;
            for (w = 1; w <= n; w++) {
                if (nr[w] != 0 && c[w][nr[w]] > c[w][u])
                    nr[w] = u;
            }
        }
        System.out.println("Minimum Spanning Tree:");
        for (i = 1; i < n; i++)
            System.out.println(st[i][1] + " <-> " + st[i][2]);
        System.out.println("Minimum Cost = " + minCost);
    }
    public static void main(String[] args) {
        Prims p = new Prims();
        p.read();
        p.primsAlg();
    }
}
