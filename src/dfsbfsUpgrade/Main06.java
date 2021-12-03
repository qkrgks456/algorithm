package dfsbfsUpgrade;

import java.util.Scanner;

public class Main06 {
    static int[][] ints;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        ints = new int[n1 + 1][n2 + 1];
        System.out.println(DFS(n1, n2));
    }

    public static int DFS(int n1, int n2) {
        if (ints[n1][n2] != 0) {
            return ints[n1][n2];
        }
        if (n1 == n2 || n2 == 0) {
            ints[n1][n2] = 1;
            return 1;
        }
        return ints[n1][n2] = DFS(n1 - 1, n2 - 1) + DFS(n1 - 1, n2);
    }
}
