package baekjoon.v1.etc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13460 {
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] chars;
    static int[][][][] ch;
    static Queue<Bolls> queue = new LinkedList<>();
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        chars = new char[N][M];
        ch = new int[N][M][N][M];
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < N; i++) {
            String s = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                chars[i][j] = s.charAt(j);
                if (chars[i][j] == 'R') {
                    a = i;
                    b = j;
                } else if (chars[i][j] == 'B') {
                    c = i;
                    d = j;
                }
            }
        }
        queue.add(new Bolls(a, b, c, d));
        ch[a][b][c][d] = 1;
        BFS();
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Bolls boll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    move(boll.rx, boll.ry, boll.bx, boll.by, j);
                }
            }
            count++;
            if (count == 10) {
                System.out.println(-1);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }

    public static void move(int rx, int ry, int bx, int by, int num) {
        // 일단 빨간놈이 먼전지 파란놈이 먼전지 체크 만약이 같은자리가 아니면 어차피 이거 상관없음
        boolean redFirst = false;
        if (num == 0 && rx > bx) redFirst = true;
        if (num == 1 && ry < by) redFirst = true;
        if (num == 2 && rx < bx) redFirst = true;
        if (num == 3 && ry > by) redFirst = true;
        // 빨간놈부터 돌려
        int nx = rx, ny = ry;
        while (true) {
            nx += dx[num];
            ny += dy[num];
            if (chars[nx][ny] == '#') {
                break;
            }
            rx = nx;
            ry = ny;
            if (chars[nx][ny] == 'O') {
                break;
            }
        }

        // 퍼런놈 돌려
        nx = bx;
        ny = by;
        while (true) {
            nx += dx[num];
            ny += dy[num];
            if (chars[nx][ny] == '#') {
                break;
            }
            bx = nx;
            by = ny;
            if (chars[nx][ny] == 'O') {
                break;
            }
        }
        if (chars[bx][by] == 'O') {
            return;
        }
        // 아얘 겹치면 어떻게 되는가
        if (rx == bx && ry == by) {
            switch (num) {
                case 0:
                    if (redFirst) {
                        bx--;
                    } else {
                        rx--;
                    }
                    break;
                case 1:
                    if (redFirst) {
                        by++;
                    } else {
                        ry++;
                    }
                    break;
                case 2:
                    if (redFirst) {
                        bx++;
                    } else {
                        rx++;
                    }
                    break;
                case 3:
                    if (redFirst) {
                        by--;
                    } else {
                        ry--;
                    }
                    break;
            }
        }
        if (chars[rx][ry] == 'O') {
            System.out.println(count + 1);
            System.exit(0);
        }

        if (ch[rx][ry][bx][by] == 0) {
            ch[rx][ry][bx][by] = 1;
            queue.add(new Bolls(rx, ry, bx, by));
        }
    }
}

class Bolls {
    int rx;
    int ry;
    int bx;
    int by;

    public Bolls(int rx, int ry, int bx, int by) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
    }

}
