package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 점화식 조차 못 세운 문제 아직은 너무 어려우므로 실버단계부터
public class Main2225Check {
    static int n, k, count;
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i <= n; i++) {
            check = new int[n + 1];
            count = 0;
            recursion(1, i);
            System.out.println(count);
        }

    }

    public static void recursion(int deep, int sum) {
        // 합이 크면 더이상 ㄴㄴ
        if (k < sum) return;
        if (k == deep) {
            if (k > sum) return;
            count++;
            return;
        }
        for (int i = 0; i <= n; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                recursion(deep + 1,  sum + i);
                check[i] = 0;
            }
        }
    }
}
