package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16395 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        if (n == 1 || n == 2) {
            System.out.println(1);
            return;
        }
        int[] start = {1, 1};
        for (int i = 1; i < n - 1; i++) {
            int[] check = new int[start.length + 1];
            check[0] = 1;
            check[check.length - 1] = 1;
            for (int j = 1; j < check.length - 1; j++) {
                check[j] = start[j - 1] + start[j];
            }
            start = check;
        }
        System.out.println(start[k - 1]);
    }
}
