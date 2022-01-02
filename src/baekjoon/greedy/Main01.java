package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main01 {
    // 그리디 아니 경탄을 금치 못했다
    // 그냥 내가 생각한대로가 맞네 ??
    // 이게 어떻게 실버2야
    // 킹받네
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n1 = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (num <= n1) {
                list.add(num);
            }
        }
        int count = n1 / list.get(list.size() - 1);
        int re = n1 % list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= 0; i--) {
            if (re < list.get(i)) {
                continue;
            }
            count += re / list.get(i);
            re = re % list.get(i);
            if (re == 0) {
                break;
            }
        }
        System.out.println(count);
    }
}
