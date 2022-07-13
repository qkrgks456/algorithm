package baekjoon.etc8;


import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main17142 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Point> location = new ArrayList<>();
    static Queue<Point> queue;
    static int[] enable;
    static int n, m;
    static int[][] ints, ch, enableCheck;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        enable = new int[m];
        ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                String s = stringTokenizer.nextToken();
                if (s.equals("2")) {
                    location.add(new Point(i, j));
                }
                ints[i][j] = Integer.parseInt(s);
            }
        }
        DFS(0, 0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void DFS(int level, int index) {
        if (level == m) {
            queue = new LinkedList<>();
            ch = new int[n][n];
            enableCheck = new int[n][n];
            for (int num : enable) {
                Point point = location.get(num);
                enableCheck[point.x][point.y] = 1;
                queue.add(point);
            }
            BFS();
            return;
        }
        for (int i = index; i < location.size(); i++) {
            enable[level] = i;
            DFS(level + 1, i + 1);
        }
    }

    public static void BFS() {
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int j = 0; j < 4; j++) {
                nx = point.x + dx[j];
                ny = point.y + dy[j];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && ints[nx][ny] != 1 && enableCheck[nx][ny] == 0) {
                    enableCheck[nx][ny] = 1;
                    ch[nx][ny] = ch[point.x][point.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        // 방문 못한것과 감염걸린시간 체크
        boolean check = false;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ints[i][j] == 0 && enableCheck[i][j] == 0) {
                    check = true;
                    break;
                }
                if (ints[i][j] != 2) {
                    max = Math.max(max, ch[i][j]);
                }
            }
        }
        if (check) {
            return;
        }
        answer = Math.min(answer, max);
    }
}
