import java.util.Scanner;
public class Dijkstra {
    int n, s, v[], c[][], dist[], p[];
    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        n = sc.nextInt();
        c = new int[n+1][n+1];
        System.out.println("Enter the Adjacency Matrix:");
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                c[i][j] = sc.nextInt();
        System.out.print("Enter the Source Vertex: ");
        s = sc.nextInt();
    }
    void dijAlg() {
        v = new int[n + 1];
        dist = new int[n + 1];
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = 0;
            dist[i] = c[s][i];
            p[i] = s;
        }
        v[s] = 1;
        dist[s] = 0;
        p[s] = 0;
        int u = 0;
        for (int i = 2; i <= n; i++) {
            int min = 999;
            for (int j = 1; j <= n; j++) {
                if (v[j] == 0 && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }
            v[u] = 1;
            for (int w = 1; w <= n; w++) {
                if (v[w] == 0 && dist[w] > dist[u] + c[u][w]) {
                    dist[w] = dist[u] + c[u][w];
                    p[w] = u;
                }
            }
        }
    }
    void path(int s, int i) {
        if (p[i] != s)
            path(s, p[i]);
        System.out.print("-->" + i);
    }
    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        d.read();
        d.dijAlg();
        System.out.println("Shortest Paths:");
        for (int i = 1; i <= d.n; i++) {
            if (i != d.s) {
                System.out.print(d.s);
                d.path(d.s, i);
                System.out.println("  Distance = " + d.dist[i]);
            }
        }
    }
}
