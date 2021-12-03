package inflearn.dfsbfsUpgrade;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main04 {

    static Integer[] ints;
    static int n1;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ints = new Integer[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        n1 = scanner.nextInt();
        Arrays.sort(ints, Collections.reverseOrder());
        DFS(0, 0);
        System.out.println(min);
    }

    public static void DFS(int num, int sum) {
        if (sum > n1) {
            return;
        }
        if (num >= min) {
            return;
        }
        if (sum == n1) {
            min = Math.min(min, num);
        } else {
            for (int i = 0; i < ints.length; i++) {
                DFS(num + 1, sum + ints[i]);
            }
        }
    }
}
