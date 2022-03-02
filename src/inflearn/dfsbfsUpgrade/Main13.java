package inflearn.dfsbfsUpgrade;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main13 {
    static int n, m;
    static int ch[];
    static List<Point> home = new ArrayList<>();
    static List<Point> pizza = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        ch = new int[m];
        for (int i = 0; i < n; i++) {
            String[] strings1 = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(strings1[j]);
                if (num == 1) {
                    home.add(new Point(i, j));
                } else if (num == 2) {
                    pizza.add(new Point(i, j));
                }
            }
        }
        DFS(0, 0);
        System.out.println(result);
    }

    public static void DFS(int s, int count) {
        if (count == m) {
            int sum = 0;
            for (Point point : home) {
                int min = Integer.MAX_VALUE;
                for (int n : ch) {
                    Point point1 = pizza.get(n);
                    min = Math.min(Math.abs(point.x - point1.x) + Math.abs(point.y - point1.y), min);
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = s; i < pizza.size(); i++) {
            ch[count] = i;
            DFS(i + 1, count + 1);
        }

    }
}
