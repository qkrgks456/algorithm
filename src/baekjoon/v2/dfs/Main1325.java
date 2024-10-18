package baekjoon.v2.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main1325 {
    static List<List<Integer>> list;
    static int[] count;
    static int[] check;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        list = new ArrayList<>();
        // 인접 리스트 사용
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(stringTokenizer.nextToken());
            int right = Integer.parseInt(stringTokenizer.nextToken());
            list.get(left).add(right);
        }
        count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            check = new int[n + 1];
            DFS(i);
        }
        int max = 0;
        for (int i = 1; i < count.length; i++) {
            max = Math.max(count[i], max);
        }
        for (int i = 1; i < count.length; i++) {
            if (max == count[i]) System.out.print(i + " ");
        }
    }

    public static void DFS(int n) {
        check[n] = 1;
        for (int num : list.get(n)) {
            if (check[num] == 0) {
                count[num]++;
                DFS(num);
            }
        }
    }
}
