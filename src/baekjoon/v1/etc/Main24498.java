package baekjoon.v1.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main24498 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ints = new int[n];
        String[] strings = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        int num;
        if (n == 1) {
            System.out.println(ints[0]);
        } else if (n == 2) {
            System.out.println(Math.max(ints[0], ints[1]));
        } else {
            int max = 0;
            for (int i = 1; i < n - 1; i++) {
                if (ints[i - 1] >= 1 && ints[i + 1] >= 1 && ints[i] >= 1) {
                    if (ints[i - 1] > ints[i] + ints[i + 1]) {
                        max = Math.max(max, ints[i - 1]);
                    } else if (ints[i + 1] > ints[i] + ints[i - 1]) {
                        max = Math.max(max, ints[i + 1]);
                    } else {
                        num = Math.min(ints[i - 1], ints[i + 1]);
                        max = Math.max(max, ints[i] + num);
                    }
                }
            }
            System.out.println(max);
        }
    }
}
