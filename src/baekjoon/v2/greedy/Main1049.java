package baekjoon.v2.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1049 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] packs = new int[m];
        int[] counts = new int[m];
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int pack = Integer.parseInt(stringTokenizer.nextToken());
            int count = Integer.parseInt(stringTokenizer.nextToken());
            packs[i] = pack;
            counts[i] = count;
        }
        Arrays.sort(packs);
        Arrays.sort(counts);
        if (n < 6) {
            if (packs[0] <= n * counts[0]) {
                System.out.println(packs[0]);
                return;
            }
            System.out.println(n * counts[0]);
            return;
        }
        int result = Integer.MAX_VALUE;
        if (packs[0] <= counts[0] * 6) {
            int s = n % 6;
            if (s == 0) {
                result = Math.min(result, (n / 6) * packs[0]);
            } else {
                if (s * counts[0] > packs[0]) {
                    result = Math.min(result, (n / 6 + 1) * packs[0]);
                } else {
                    result = Math.min(result, (n / 6) * packs[0] + s * counts[0]);
                }
            }
        } else {
            result = Math.min(result, counts[0] * n);
        }
        System.out.println(result);
    }
}


