package programmers.problem.level2.level2_6;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] ch;

    public int solution(int[][] maps) {
        ch = new int[maps.length][maps[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        ch[0][0] = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length && maps[nx][ny] == 1 && ch[nx][ny] == 0) {
                    ch[nx][ny] = ch[point.x][point.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        if (ch[ch.length - 1][ch[0].length - 1] != 0) {
            return ch[ch.length - 1][ch[0].length - 1];
        }
        return -1;
    }
}
