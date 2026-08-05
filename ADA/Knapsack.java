import java.util.Scanner;
public class Knapsack {
    int n, m;
    int v[][] = new int[10][10];
    int w[] = new int[10];
    int p[] = new int[10];
    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of objects: ");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter weight and profit of Object " + i + ":");
            w[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        System.out.print("Enter the capacity of knapsack: ");
        m = sc.nextInt();
    }
    void optimalSolution() {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    v[i][j] = 0;
                else if (j < w[i])
                    v[i][j] = v[i - 1][j];
                else
                    v[i][j] = Math.max(v[i - 1][j],
                                       v[i - 1][j - w[i]] + p[i]);
            }
        }
    }
    void output() {
        int x[] = new int[10];
        System.out.println("Optimal Solution Matrix:");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++)
                System.out.print(v[i][j] + " ");
            System.out.println();
        }
        System.out.println("Maximum Profit = " + v[n][m]);
        int i = n;
        int j = m;
        while (i != 0 && j != 0) {
            if (v[i][j] != v[i - 1][j]) {
                x[i] = 1;
                j -= w[i];
            }
            i--;
        }
        System.out.println("Objects Selected:");
        for (i = 1; i <= n; i++)
            if (x[i] == 1)
                System.out.println(i);
    }
    public static void main(String args[]) {
        Knapsack k = new Knapsack();
        k.input();
        k.optimalSolution();
        k.output();
    }
}
