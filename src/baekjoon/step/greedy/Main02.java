package baekjoon.step.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++) {
            ints[i][0] = scanner.nextInt();
            ints[i][1] = scanner.nextInt();
        }
        // 이차원 배열 정렬만 알면 쉬움 둘째자리 정렬하면 게임 끝
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                if (e1[1] == e2[1]) {        // 첫번째 원소가 같다면 두 번째 원소끼리 비교
                    return e1[0] - e2[0];
                } else {
                    return e1[1] - e2[1];
                }
            }
        });
        int count = 1;
        int check = ints[0][1];
        for (int i = 1; i < ints.length; i++) {
            if (ints[i][0] >= check) {
                count++;
                check = ints[i][1];
            }
        }
        System.out.println(count);
    }
}
