import java.util.Scanner;
public class NQueens {
    static int n, x[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the chessboard (n): ");
        n = sc.nextInt();
        x = new int[n + 1];
        System.out.println("Solutions for " + n + " x " + n + " Chessboard:");
        solve(1);
        sc.close();
    }
    static boolean placeQueen(int k, int i) {
        for (int j = 1; j < k; j++)
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k))
                return false;
        return true;
    }
    static void solve(int k) {
        if (k > n) {
            printSolution();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (placeQueen(k, i)) {
                x[k] = i;
                solve(k + 1);
            }
        }
    }
    static void printSolution() {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        for (int i = 1; i <= n; i++)
            board[i - 1][x[i] - 1] = 'Q';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}
