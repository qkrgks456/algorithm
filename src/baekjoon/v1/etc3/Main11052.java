package baekjoon.v1.etc3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11052 {
    static int N;
    static int[] ints, result;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        ints = new int[N + 1];
        result = new int[N + 1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i < ints.length; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i = 1; i < ints.length; i++) {
            for (int j = 1; j <= i; j++) {
                result[i] = Math.max(result[i], result[i - j] + ints[j]);
            }
        }
        System.out.println(result[N]);
    }
}
