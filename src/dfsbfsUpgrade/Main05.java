package dfsbfsUpgrade;

import java.util.Scanner;

public class Main05 {
    static int[] pm;
    static int n1, n2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        pm = new int[n2];
        DFS(0);
    }

    public static void DFS(int num) {
        if (num == n2) {
            for (int n : pm) {
                System.out.print(n + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n1; i++) {
                pm[num] = i;
                DFS(num + 1);
            }
        }
    }

}
