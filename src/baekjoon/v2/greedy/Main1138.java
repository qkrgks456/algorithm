package baekjoon.v2.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1138 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ints = new int[n + 1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int count = 0;
            int check = ints[i];
            for (int j = 1; j <= n; j++) {
                if (result[j] == 0) {
                    if (check == count) {
                        result[j] = i;
                    }
                    count++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
