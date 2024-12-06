package baekjoon.v1.etc10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main25305 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Integer[] ints = new Integer[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(ints, Comparator.reverseOrder());
        System.out.println(ints[m - 1]);

    }
}
