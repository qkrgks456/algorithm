package baekjoon.v2.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int result = 0;
        for (int i = ints.length - 1; i >= 0; i--) {
            if (k / ints[i] != 0) {
                result += k / ints[i];
                k -= (k / ints[i]) * ints[i];
            }
            if (k == 0) break;
        }
        System.out.println(result);
    }
}
