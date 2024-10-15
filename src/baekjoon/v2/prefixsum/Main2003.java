package baekjoon.v2.prefixsum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2003 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] ints = new int[N];
        int sum = 0;
        int start = 0;
        int end = 0;
        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int result = 0;
        while (true) {
            if (sum < M) {
                if (end < N) {
                    sum += ints[end];
                    end++;
                } else {
                    break;
                }
            } else if (sum == M) {
                result++;
                sum -= ints[start];
                start++;
            } else {
                sum -= ints[start];
                start++;
            }

        }
        System.out.println(result);
    }
}
