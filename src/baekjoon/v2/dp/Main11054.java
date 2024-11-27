package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11054 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int[] ints = new int[1001];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] leftDp = new int[1001];
        int[] rightDp = new int[1001];
        int end = n - 1;
        for (int i = 0; i < n; i++) {
            leftDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (ints[i] > ints[j]) {
                    leftDp[i] = Math.max(leftDp[i], leftDp[j] + 1);
                }
            }
            rightDp[end] = 1;
            for (int j = n - 1; j > end; j--) {
                if (ints[end] > ints[j]) {
                    rightDp[end] = Math.max(rightDp[end], rightDp[j] + 1);
                }
            }
            end--;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, leftDp[i] + rightDp[i] - 1);
        }
        System.out.println(result);
    }
}
