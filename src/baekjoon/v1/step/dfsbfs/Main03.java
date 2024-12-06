package baekjoon.v1.step.dfsbfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main03 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] ch, ints;
    static int size;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());
        ints = new int[size][size];
        ch = new int[size][size];
        int firstCount = 0;
        for (int i = 0; i < size; i++) {
            String s = bufferedReader.readLine();
            String[] strings = s.split("");
            for (int j = 0; j < size; j++) {
                ints[i][j] = Integer.parseInt(strings[j]);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (ints[i][j] == 1 && ch[i][j] == 0) {
                    BFS(i, j);
                    firstCount++;
                }
            }
        }
        System.out.println(firstCount);
        Collections.sort(list);
        for (int n : list) {
            System.out.println(n);
        }
    }

    public static void BFS(int x, int y) {
        int nx, ny;
        Queue<Point> queue = new LinkedList<>();
        int count = 1;
        queue.add(new Point(x, y));
        ch[x][y] = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
                    if (ints[nx][ny] == 1 && ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                        count++;
                    }
                }
            }
        }
        list.add(count);
    }
}
