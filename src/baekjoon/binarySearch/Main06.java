package baekjoon.binarySearch;

import java.util.Scanner;

public class Main06 {
    public static void main(String[] args) {
        // 배열 못만듬 절대 안됨
        // 다른 방법을 찾아야 함
        // 거의다 됐는데 사부럴꺼
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int l = 1;
        int r = k;
        while (l < r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (mid / i > n) {
                    count += n;
                } else {
                    count += (mid / i);
                }
            }
            if (count >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }
}
