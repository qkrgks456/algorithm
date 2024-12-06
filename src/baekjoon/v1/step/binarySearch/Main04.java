package baekjoon.v1.step.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main04 {
    // 전번 문제랑 뭐가 다른거냐 ㅋㅋ
    // 포문 돌릴때 조건 다르게 다네
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        int n = Integer.parseInt(strings[0]);
        long m = Long.parseLong(strings[1]);
        long[] longs = new long[n];
        long max = 0;
        String s1 = bufferedReader.readLine();
        String[] strings1 = s1.split(" ");
        for (int i = 0; i < n; i++) {
            longs[i] = Integer.parseInt(strings1[i]);
            if (max < longs[i]) {
                max = longs[i];
            }
        }
        long l = 0;
        long r = max + 1;
        long mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            long count = 0;
            for (int i = 0; i < longs.length; i++) {
                if (longs[i] > mid) {
                    count += longs[i] - mid;
                }
            }
            if (count >= m) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(l - 1);
    }
}
