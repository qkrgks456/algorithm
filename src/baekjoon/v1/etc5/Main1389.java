package baekjoon.v1.etc5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1389 {
    static List<ArrayList<Integer>> list;
    static int[] ch;
    static int N, M;
    static int resultSum = Integer.MAX_VALUE;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }
        for (int i = 1; i < N + 1; i++) {
            BFS(i);
        }
        System.out.println(result);
    }

    private static void BFS(int num) {
        ch = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        while (!queue.isEmpty()) {
            Integer n = queue.poll();
            for (int nums : list.get(n)) {
                if (ch[nums] == 0) {
                    ch[nums] = ch[n] + 1;
                    queue.add(nums);
                }
            }
        }
        int sum = 0;
        for (int i = 1; i < ch.length; i++) {
            if (i == num) continue;
            sum += ch[i];
        }
        if (resultSum > sum) {
            result = num;
            resultSum = sum;
        }
    }
}
