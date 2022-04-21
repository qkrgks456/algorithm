package baekjoon.step.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        Collections.sort(list);
        int max = list.get(list.size() - 1);
        int min = list.get(0);
        double sum = 0;
        // 산술평균 구하기
        for (int num : list) {
            sum += num;
        }
        // 최빈수 구하기
        int[] arr = new int[8001];
        int max2 = Integer.MIN_VALUE;
        ArrayList<Integer> list2 = new ArrayList<>();
        // 카운트하면서 최빈수 찾기
        for (int num : list) {
            arr[num + 4000]++;
            max2 = Math.max(max2, arr[num + 4000]);
        }
        // 최빈수들만 list2에 넣기
        for (int i = 0; i <= 8000; i++) {
            if (arr[i] == max2) {
                list2.add(i - 4000);
            }
        }

        // 산술평균 o
        System.out.println(Math.round(sum / n));

        // 중앙값 o
        if (n != 1) {
            System.out.println(list.get(n / 2));
        } else {
            System.out.println(list.get(0));
        }

        // 최빈값
        if (list2.size() == 1) {
            System.out.println(list2.get(0));
        } else {
            Collections.sort(list2);
            System.out.println(list2.get(1));
        }

        // 범위 o
        System.out.print(max - min);
    }
}
