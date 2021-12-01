package dfsbfsUpgrade;

import java.util.Scanner;

public class Main02 {
    static int n1, n2;
    static int[] ints;
    static int max;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        ints = new int[n2];
        for (int i = 0; i < n2; i++) {
            ints[i] = scanner.nextInt();
        }
        DFS(0, 0);
        System.out.println(max);
    }

    public static void DFS(int num, int sum) {
        if (sum > n1) {
            return;
        }
        if (num == n2) {
            max = Math.max(max, sum);
        } else {
            DFS(num + 1, sum + ints[num]);
            DFS(num + 1, sum);
        }
    }
}
