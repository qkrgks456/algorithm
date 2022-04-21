package baekjoon.step.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main03 {
    // 아 다 풀었는데 Math.max로 하니까 안되네
    // 고작 그것때문에 핵 킹받네 ㅡ.ㅡ
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        int k = Integer.parseInt(strings[0]);
        int n = Integer.parseInt(strings[1]);
        int[] ints = new int[k];
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            ints[i] = Integer.parseInt(bufferedReader.readLine());
            if (ints[i] > max) {
                max = ints[i];
            }
        }
        long l = 0;
        long r = max + 1;
        long mid;
        while (l < r) {
            mid = (l + r) / 2;
            long count = 0;
            for (int i = 0; i < ints.length; i++) {
                count += ints[i] / mid;
            }
            if (count >= n) {
                l = mid + 1;
            } else if (count < n) {
                r = mid;
            }
        }
        System.out.println(l - 1);
    }
}
