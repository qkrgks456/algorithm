package baekjoon.v2.prefixsum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main21921 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int X = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(br.readLine());
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        List<Integer> sumList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += ints[i];
        }
        sumList.add(sum);
        int left = 0;
        int right = X - 1;
        // 구간별 최대합
        while (true) {
            left++;
            right++;
            if (right >= N) break;
            sum -= ints[left - 1];
            sum += ints[right];
            sumList.add(sum);
        }

        int max = Integer.MIN_VALUE;
        for (int n : sumList) {
            max = Math.max(max, n);
        }
        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        int count = 0;
        for (int n : sumList) {
            if (max == n) count++;
        }
        System.out.println(max);
        System.out.println(count);

    }
}
