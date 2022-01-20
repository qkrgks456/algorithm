package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main07 {
    // 가장 긴 증가 부분 수열부터 기억 했는데 ㅅㅂ
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ints = new int[n];
        int[] check = new int[n];
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        // 100만이면 시간 그냥 터져 버리쥬 이분탐색을 활용해라 ?
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < ints.length; i++) {
            check[i] = 1;
            for (int j = 0; j < ints.length; j++) {
                if (ints[i] > ints[j] && check[i] < check[j] + 1) {
                    check[i] += 1;
                }
            }
            result = Math.max(result, check[i]);
        }

        int l = 1;
        int r = n + 1;
        while (l < r) {
            int mid = (l + r) / 2;

        }


    }
}
