package baekjoon.v1.etc10;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class Main9205 {
    public static void main(String[] args) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        int sx = 0, sy = 0, ex = 0, ey = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            List<Point> list = new ArrayList<>();
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int j = 0; j < n + 2; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());
                if (j == 0) {
                    sx = x;
                    sy = y;
                } else if (j == n + 1) {
                    ex = x;
                    ey = y;
                } else {
                    list.add(new Point(x, y));
                }
            }

            Queue<Point> queue = new LinkedList<>();
            int[] ch = new int[n];
            queue.add(new Point(sx, sy));
            boolean result = false;
            while (!queue.isEmpty()) {
                Point point = queue.poll();
                if (Math.abs(point.x - ex) + Math.abs(point.y - ey) <= 1000) {
                    result = true;
                    break;
                }
                for (int j = 0; j < n; j++) {
                    Point check = list.get(j);
                    if (ch[j] == 0 && Math.abs(point.x - check.x) + Math.abs(point.y - check.y) <= 1000) {
                        ch[j] = 1;
                        queue.add(new Point(check.x, check.y));
                    }
                }
            }
            if (result) {
                stringBuilder.append("happy\n");
            } else {
                stringBuilder.append("sad\n");
            }
        }
        System.out.print(stringBuilder);
    }
}

