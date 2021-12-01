package dfsbfsUpgrade;

import java.util.Scanner;

public class Main01 {
    static int[] ints;
    static int total, n = 0;
    static String result = "NO";
    static boolean check = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
            total += ints[i];
        }
        DFS(0, 0);
        System.out.println(result);
    }

    public static void DFS(int num, int sum) {
        if (check) {
            return;
        }
        if (n == num) {
            if ((total-sum) == sum) {
                result = "YES";
                check = true;
            }
        } else {
            DFS(num + 1, sum + ints[num]);
            DFS(num + 1, sum);
        }
    }
}
