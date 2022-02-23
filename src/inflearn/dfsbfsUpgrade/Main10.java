package inflearn.dfsbfsUpgrade;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main10 {
    static int[][] ints, result, ch;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        ints = new int[7][7];
        result = new int[7][7];
        ch = new int[7][7];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 7; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            for (int j = 0; j < 7; j++) {
                ints[i][j] = Integer.parseInt(strings[j]);
            }
        }
        BFS();
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 7 && ny < 7 && ints[nx][ny] == 0 && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    result[nx][ny] = result[point.x][point.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        if (result[6][6] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result[6][6]);
        }
    }
}
