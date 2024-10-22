package baekjoon.v2.twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ints = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(ints);
        int start = 0;
        int end = n - 1;
        int bestSum = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (start < end) {
            int curSum = ints[start] + ints[end];
            if(Math.abs(curSum) < Math.abs(bestSum)) {
                bestSum = curSum;
                result[0] = ints[start];
                result[1] = ints[end];
            }
            if (curSum < 0) {
                start++;
            } else if (curSum > 0) {
                end--;
            } else {
                // 0이라면 끝
                System.out.println(ints[start] + " " + ints[end]);
                return;
            }
        }
        System.out.println(result[0] + " " + result[1]);

    }
}
