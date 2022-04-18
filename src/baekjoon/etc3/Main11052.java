package baekjoon.etc3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11052 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] ints = new int[N + 1];
        int[] result = new int[N + 1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i < ints.length; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        result[1] = ints[1] * N;
    }
}
