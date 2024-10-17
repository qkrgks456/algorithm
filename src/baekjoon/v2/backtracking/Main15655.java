package baekjoon.v2.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15655 {
    static int N, M;
    static int[] ints, check, result;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[N];
        result = new int[M];
        check = new int[N + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(ints);
        DFS(0, 0);

    }

    public static void DFS(int index, int deep) {
        if (deep == M) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < ints.length; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                result[deep] = ints[i];
                DFS(i, deep + 1);
                check[i] = 0;
            }
        }

    }
}
