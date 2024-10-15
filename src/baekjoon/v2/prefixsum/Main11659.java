package baekjoon.v2.prefixsum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11659 {

    static int N, M, n1, n2;
    static int[] ints, sum;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[N + 1];
        sum = new int[N + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
            sum[i] = ints[i] + sum[i - 1];
        }
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            n1 = Integer.parseInt(stringTokenizer.nextToken());
            n2 = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(sum[n2] - (sum[n1] - ints[n1]));

        }

    }
}
