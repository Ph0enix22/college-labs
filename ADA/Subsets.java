import java.util.Scanner;
public class Subsets {
    static int n, d, sum = 0, c = 0;
    static int w[] = new int[10];
    static int x[] = new int[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        n = sc.nextInt();
        System.out.println("Enter the elements in increasing order:");
        for (int i = 0; i < n; i++)
            w[i] = sc.nextInt();
        System.out.print("Enter the value of d: ");
        d = sc.nextInt();
        for (int i = 0; i < n; i++)
            sum += w[i];
        System.out.println("SUM = " + sum);
        if (sum < d || w[0] > d) {
            System.out.println("Subset is not possible!");
            return;
        }
        subset(0, 0, sum);
        if (c == 0)
            System.out.println("Subset is not possible!");
    }
    static void subset(int wsf, int k, int trw) {
        x[k] = 1;
        if (wsf + w[k] == d) {
            System.out.println("Subset Solution = " + (++c));
            for (int i = 0; i <= k; i++)
                if (x[i] == 1)
                    System.out.print(w[i] + " ");
            System.out.println();
            return;
        }
        if (wsf + w[k] + w[k + 1] <= d)
            subset(wsf + w[k], k + 1, trw - w[k]);
        if ((wsf + trw - w[k] >= d) && (wsf + w[k + 1] <= d)) {
            x[k] = 0;
            subset(wsf, k + 1, trw - w[k]);
        }
    }
}
