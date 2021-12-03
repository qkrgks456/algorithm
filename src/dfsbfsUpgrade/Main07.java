package dfsbfsUpgrade;

import java.util.Scanner;

public class Main07 {
    static int[] ints, ch, p;
    static int n, f, n1, n2;
    static int[][] arr = new int[70][70];
    static boolean check = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        ints = new int[n1];
        p = new int[n1];
        ch = new int[n1 + 1];
        for (int i = 0; i < n1; i++) {
            ints[i] = me(n1 - 1, i);
        }
        DFS(0, 0);
    }

    public static void DFS(int num, int sum) {
        if (check) {
            return;
        }
        if (num == n1) {
            if (sum == n2) {
                for (int n : p) {
                    System.out.print(n + " ");
                }
                check = true;
            }
        } else {
            for (int i = 1; i <= n1; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[num] = i;
                    DFS(num + 1, sum + p[num] * ints[num]);
                    ch[i] = 0;
                }
            }
        }
    }

    public static int me(int n, int f) {
        if (arr[n][f] > 0) {
            return arr[n][f];
        }
        if (n == f || f == 0) {
            return 1;
        } else {
            return arr[n][f] = me(n - 1, f - 1) + me(n - 1, f);
        }
    }
}
