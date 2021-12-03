package inflearn.dfsbfsUpgrade;

import java.util.Scanner;

public class Main08 {
    static int[] ch, com;
    static int n1, n2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        com = new int[n2];
        ch = new int[n1 + 1];
        DFS(0, 1);
    }

    public static void DFS(int l, int num) {
        if (l == n2) {
            for (int n : com) {
                System.out.print(n + " ");
            }
            System.out.println();
        } else {
            for (int i = num; i <= n1; i++) {
                com[l] = i;
                DFS(l + 1, i + 1);
            }
        }
    }

}
