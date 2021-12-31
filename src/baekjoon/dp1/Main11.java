package baekjoon.dp1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        // LIS 구하기 (최장 증가 수열)
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }
        list.add(0, ints[0]);
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] > list.get(list.size() - 1)) {
                list.add(ints[i]);
            } else {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) >= ints[i]) {
                        list.set(j, ints[i]);
                        break;
                    }
                }
            }
        }
        System.out.println(list.size());
    }
}
