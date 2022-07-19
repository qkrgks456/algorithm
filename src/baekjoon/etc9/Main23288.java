package baekjoon.etc9;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main23288 {
    // 동 북 서 남
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] ints;
    static int N, M, K;
    static Dice dice = new Dice(0, 0, 0, 1, 6, 3, 4, 5, 2);
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            move();
            getPoint();
            directionChange();
        }
        System.out.println(result);
    }

    public static void directionChange() {
        if (ints[dice.x][dice.y] > dice.down) {
            dice.direction = dice.direction + 1 > 3 ? 0 : dice.direction + 1;
        } else if (ints[dice.x][dice.y] < dice.down) {
            dice.direction = dice.direction - 1 < 0 ? 3 : dice.direction - 1;
        }
    }

    // 여기가 BFS
    public static void getPoint() {
        Queue<Point> queue = new LinkedList<>();
        int[][] ch = new int[N][M];
        ch[dice.x][dice.y] = 1;
        queue.add(new Point(dice.x, dice.y));
        int nx, ny;
        int count = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && ints[dice.x][dice.y] == ints[nx][ny] && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    count++;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        result += count * ints[dice.x][dice.y];
    }

    public static void move() {
        int nx, ny;
        nx = dice.x + dx[dice.direction];
        ny = dice.y + dy[dice.direction];
        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
            dice.x = nx;
            dice.y = ny;
            int up = dice.up;
            int down = dice.down;
            int top = dice.top;
            int bottom = dice.bottom;
            int left = dice.left;
            int right = dice.right;
            // 칸 안 벗어나면
            // 동서남북 -> 동북서남
            switch (dice.direction) {
                case 0:
                    dice.down = right;
                    dice.up = left;
                    dice.right = up;
                    dice.left = down;
                    break;
                case 1:
                    dice.down = top;
                    dice.up = bottom;
                    dice.bottom = down;
                    dice.top = up;
                    break;
                case 2:
                    dice.down = left;
                    dice.up = right;
                    dice.right = down;
                    dice.left = up;
                    break;
                case 3:
                    dice.down = bottom;
                    dice.up = top;
                    dice.bottom = up;
                    dice.top = down;
                    break;
            }
        } else {
            // 칸 벗어나면
            if (dice.direction == 0 || dice.direction == 1) {
                dice.direction += 2;
            } else {
                dice.direction -= 2;
            }
            move();
        }
    }
}

class Dice {
    int x;
    int y;
    int direction;
    int up;
    int down;
    int top;
    int bottom;
    int left;
    int right;

    public Dice(int x, int y, int direction, int up, int down, int right, int left, int bottom, int top) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
        this.bottom = bottom;
        this.top = top;
    }
}
