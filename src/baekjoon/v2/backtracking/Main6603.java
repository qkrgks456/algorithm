package baekjoon.v2.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603 {
    static int[] ints, check, result;
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            int k = Integer.parseInt(stringTokenizer.nextToken());
            if (k == 0) break;
            ints = new int[k];
            check = new int[k];
            result = new int[6];
            for (int i = 0; i < k; i++) {
                ints[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            stringBuilder = new StringBuilder();
            DFS(0, 0);
            System.out.println(stringBuilder);
        }
    }

    public static void DFS(int index, int deep) {
        if (deep == 6) {
            for (int i : result) {
                stringBuilder.append(i).append(" ");
            }
            stringBuilder.append("\n");
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
