package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class ThreePoint {
    int x;
    int y;
    int z;

    public ThreePoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main07 {

    static int[][][] ch, result;
    static int m, n, h;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<ThreePoint> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        m = Integer.parseInt(strings[0]);
        n = Integer.parseInt(strings[1]);
        h = Integer.parseInt(strings[2]);
        ch = new int[h][n][m];
        result = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                String s1 = bufferedReader.readLine();
                String[] strings1 = s1.split(" ");
                for (int k = 0; k < m; k++) {
                    int num = Integer.parseInt(strings1[k]);
                    if (num == 1) {
                        queue.add(new ThreePoint(j, k, i));
                        ch[i][j][k] = 1;
                    } else if (num == -1) {
                        ch[i][j][k] = 1;
                    }
                }
            }
        }
        BFS();
        boolean check = true;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (max < result[i][j][k]) {
                        max = result[i][j][k];
                    }
                    if (ch[i][j][k] == 0) {
                        check = false;
                        break;
                    }
                }
            }
        }
        if (check) {
            System.out.println(max);
        } else {
            System.out.println(-1);
        }
    }

    public static void BFS() {
        int nx, ny, nz;
        while (!queue.isEmpty()) {
            ThreePoint point = queue.poll();
            for (int i = 0; i < 6; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                nz = point.z + dz[i];
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < h) {
                    if (ch[nz][nx][ny] == 0) {
                        ch[nz][nx][ny] = 1;
                        queue.add(new ThreePoint(nx, ny, nz));
                        result[nz][nx][ny] = result[point.z][point.x][point.y] + 1;
                    }
                }
            }
        }
    }
}
