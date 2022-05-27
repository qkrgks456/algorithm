package inflearn.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            ints[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            ints[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        // 정렬

    }
}
