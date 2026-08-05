import java.util.Scanner;
public class Floyd {
    int a[][] = new int[10][10];
    int d[][][] = new int[10][10][10];
    int n;
    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the Adjacency Matrix:");
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                a[i][j] = sc.nextInt();
    }
    void floyds() {
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                d[0][i][j] = a[i][j];
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[k][i][j] = min(d[k - 1][i][j],
                                     d[k - 1][i][k] + d[k - 1][k][j]);
                }
            }
        }
    }
    int min(int a, int b) {
        if (a < b)
            return a;
        else
            return b;
    }
    void write() {
        System.out.println("Computing All Pairs Shortest Paths:");
        for (int k = 0; k <= n; k++) {
            System.out.println("\nd[" + k + "]");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(d[k][i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
    public static void main(String args[]) {
        Floyd f = new Floyd();
        f.read();
        f.floyds();
        f.write();
    }
}
