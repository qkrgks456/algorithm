package baekjoon.v1.step.dp1;

import java.util.Scanner;

public class Main07_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n + 1];
        int[] g = new int[n + 1];
        int[] h = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ints[i] = scanner.nextInt();
        }
        if (n == 1) {
            System.out.println(ints[1]);
        } else if (n == 2) {
            System.out.println(ints[1] + ints[2]);
        } else {
            h[1] = ints[1];
            // f(x) = max(g(x),h(x))
            // g(x) = h(x-1) + arr[x]
            // h(x) = max(g(x-2),h(x-2)) + arr[x]
            // = f(x-2) + arr[x]
            int max = 0;
            for (int i = 2; i <= n; i++) {
                g[i] = h[i - 1] + ints[i];
                h[i] = Math.max(h[i - 2], g[i - 2]) + ints[i];
                max = Math.max(g[i], h[i]);
            }
            System.out.println(max);
        }
    }
}
