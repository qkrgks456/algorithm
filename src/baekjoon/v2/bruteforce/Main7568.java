package baekjoon.v2.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main7568 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] ints = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            ints[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            ints[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int count = 1;
            int weight = ints[i][0];
            int height = ints[i][1];
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (ints[j][0] > weight && ints[j][1] > height) {
                    count++;
                }
            }
            result[i] = count;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            stringBuilder.append(result[i]).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
