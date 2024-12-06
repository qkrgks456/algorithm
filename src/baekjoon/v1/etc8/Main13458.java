package baekjoon.v1.etc8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13458 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (ints[i] - b <= 0) {
                sum += 1;
                continue;
            }
            int num = (ints[i] - b) % c == 0 ? (ints[i] - b) / c : (ints[i] - b) / c + 1;
            sum += num + 1;
        }
        System.out.println(sum);
    }
}
