package baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main14501 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] t = new int[n];
        int[] p = new int[n];
        int[] result = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            t[i] = Integer.parseInt(strings[0]);
            p[i] = Integer.parseInt(strings[1]);
        }

        // 뭐야 왜 이렇게 어려워
        for (int i = 0; i < n; i++) {
            result[i] = Math.max(result[i], max);
            result[t[i] + i] = Math.max(result[t[i] + i], p[i] + result[i]);
            max = Math.max(max, result[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
