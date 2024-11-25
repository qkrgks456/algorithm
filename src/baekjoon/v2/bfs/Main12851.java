package baekjoon.v2.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12851 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        if (n == k) {
            System.out.println(0);
            System.out.println(0);
            return;
        }
        if (n > k) {
            System.out.println(n - k);
            System.out.println(0);
            return;
        }
        if (n % k == 0) {
            System.out.println(n / k);
            System.out.println(1);
            return;
        }
        int seconds = Math.min(((k / n) + (k % n)) - 1, ((k / n + 1) + n * (k / n + 1) - k) - 1);
        System.out.println(seconds);
        // 5 4 8 16 17
        // 5 10 15 16 17 4초는 구했다 치자
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        boolean flag = false;

    }
}