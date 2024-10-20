package baekjoon.v2.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2529 {
    static long maxResult = Long.MIN_VALUE;
    static long minResult = Long.MAX_VALUE;
    static String maxString;
    static String minString;
    static int n;
    static String[] strings;
    static int[] combine;
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = stringTokenizer.nextToken();
        }
        for (int i = 0; i <= 9; i++) {
            combine = new int[n + 1];
            check = new int[10];
            combine[0] = i;
            check[i] = 1;
            recursion(i, 1);
        }
        System.out.println(maxString);
        System.out.println(minString);

    }

    public static void recursion(int num, int deep) {
        if (deep == n + 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : combine) {
                stringBuilder.append(i);
            }
            long sum = Long.parseLong(stringBuilder.toString());
            if (sum >= maxResult) {
                maxString = stringBuilder.toString();
                maxResult = sum;
            }
            if (sum <= minResult) {
                minString = stringBuilder.toString();
                minResult = sum;
            }
            return;
        }
        if (strings[deep - 1].equals(">")) {
            for (int i = 0; i < num; i++) {
                if (check[i] == 1) continue;
                check[i] = 1;
                combine[deep] = i;
                recursion(i, deep + 1);
                check[i] = 0;
            }
        }
        if (strings[deep - 1].equals("<")) {
            for (int i = num + 1; i <= 9; i++) {
                if (check[i] == 1) continue;
                check[i] = 1;
                combine[deep] = i;
                recursion(i, deep + 1);
                check[i] = 0;
            }
        }

    }
}
