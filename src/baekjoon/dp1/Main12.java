package baekjoon.dp1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main12 {
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();
    static int[] ints, ch1, ch2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ints = new int[n];
        ch1 = new int[n];
        ch2 = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        list.add(ints[0]);
        list2.add(ints[0]);
        for (int i = 1; i < n; i++) {
            // 증가 수열 최대
            first(i);
            // 감소 수열 최대
            second(i);
        }
    }

    public static void first(int num) {
        if (ints[num] > list.get(list.size() - 1)) {
            list.add(ints[num]);
        } else {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) >= ints[num]) {
                    list.set(j, ints[num]);
                    break;
                }
            }
        }
    }

    public static void second(int num) {
        if (ints[num] < list2.get(list2.size() - 1)) {
            list2.add(ints[num]);
        } else {
            for (int j = 0; j < list.size(); j++) {
                if (list2.get(j) <= ints[num]) {
                    list2.set(j, ints[num]);
                    break;
                }
            }
        }
    }
}
