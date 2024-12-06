package baekjoon.v1.step.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main05 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        int n = Integer.parseInt(strings[0]);
        int c = Integer.parseInt(strings[1]);
        long[] longs = new long[n];
        for (int i = 0; i < n; i++) {
            longs[i] = Long.parseLong(bufferedReader.readLine());
        }
        Arrays.sort(longs);
        long l = 1;
        long r = longs[n - 1] - longs[0] + 1;
        while (l < r) {
            long mid = (l + r) / 2;
            int count = 1;
            long front = longs[0];
            for (int i = 1; i < longs.length; i++) {
                if (longs[i] - front >= mid) {
                    count++;
                    front = longs[i];
                }
            }
            if (count >= c) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(l - 1);
    }
}
