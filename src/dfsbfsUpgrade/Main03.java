package dfsbfsUpgrade;

import java.util.Scanner;

public class Main03 {

    static int n2, n1;
    static int times[];
    static int points[];
    static int max;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        times = new int[n1];
        points = new int[n1];
        for (int i = 0; i < n1; i++) {
            points[i] = scanner.nextInt();
            times[i] = scanner.nextInt();
        }
        DFS(0, 0, 0);
        System.out.println(max);
    }

    public static void DFS(int num, int timeTotal, int pointTotal) {
        if (timeTotal > n2) {
            return;
        }
        if (num == n1) {
            max = Math.max(max, pointTotal);
        } else {
            DFS(num + 1, timeTotal + times[num], pointTotal + points[num]);
            DFS(num + 1, timeTotal, pointTotal);
        }
    }
}
