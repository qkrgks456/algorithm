package baekjoon.etc7;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main15686 {
    static List<Point> list = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();
    static int n, m;
    static int[] comb, ch;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        comb = new int[m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                int n = Integer.parseInt(stringTokenizer.nextToken());
                if (n == 1) {
                    list.add(new Point(i, j));
                } else if (n == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        ch = new int[chicken.size()];
        DFS(0, 0);
        System.out.println(result);
    }

    public static void DFS(int idx, int level) {
        if (level == m) {
            result = Math.min(distance(comb), result);
            return;
        }
        for (int i = idx; i < chicken.size(); i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                comb[level] = i;
                DFS(i + 1, level + 1);
                ch[i] = 0;
            }
        }
    }

    public static int distance(int[] ints) {
        int sum = 0;
        for (Point point : list) {
            int min = Integer.MAX_VALUE;
            for (int n : ints) {
                Point chickens = chicken.get(n);
                min = Math.min(min, Math.abs(point.x - chickens.x) + Math.abs(point.y - chickens.y));
            }
            sum += min;
        }
        return sum;
    }
}
