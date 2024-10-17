package baekjoon.v2.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2798 {
    static int[] ints, check, result;
    static int n, m, sumResult;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[n];
        check = new int[n];
        result = new int[3];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        sumResult = Integer.MIN_VALUE;
        DFS(0);
        System.out.println(sumResult);
    }

    public static void DFS(int deep) {
        if (deep == 3) {
            int sum = 0;
            for (int i : result) {
                sum += i;
            }
            if (m < sum) return;
            sumResult = Math.max(sumResult, sum);
            return;
        }

        for (int i = 0; i < ints.length; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                result[deep] = ints[i];
                DFS(deep + 1);
                check[i] = 0;
            }
        }
    }
}
