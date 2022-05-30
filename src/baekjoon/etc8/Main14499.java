package baekjoon.etc8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14499 {

    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int n, m;
    static int[] direction;
    static int[][] ints;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        int x = Integer.parseInt(stringTokenizer.nextToken());
        int y = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        direction = new int[k];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < k; i++) {
            direction[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        find(x, y);
        System.out.println(stringBuilder);
    }

    private static void find(int x, int y) {
        Queue<My> queue = new LinkedList<>();
        queue.add(new My(x, y, new Dice(0, 0, 0, 0, 0, 0)));
        int nx, ny;
        int count = 0;
        for (int num : direction) {
            count++;
            My my = queue.poll();
            nx = my.x + dx[num];
            ny = my.y + dy[num];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                // 하 문제는 주사위인데 저걸 어쩐다 이거 배열 위치 교체 해줘야겠네
                // 1 동 2 서 3 북 4 남
                int right;
                int left;
                int bottom;
                int top;
                int high;
                int row;
                switch (num) {
                    case 1:
                        top = my.dice.top;
                        bottom = my.dice.bottom;
                        high = my.dice.left;
                        row = my.dice.right;
                        right = my.dice.high;
                        left = my.dice.row;
                        row = copy(nx, ny, row);
                        stringBuilder.append(high + "\n");
                        queue.add(new My(nx, ny, new Dice(right, left, bottom, top, high, row)));
                        break;
                    case 2:
                        top = my.dice.top;
                        bottom = my.dice.bottom;
                        high = my.dice.right;
                        row = my.dice.left;
                        right = my.dice.row;
                        left = my.dice.high;
                        row = copy(nx, ny, row);
                        stringBuilder.append(high + "\n");
                        queue.add(new My(nx, ny, new Dice(right, left, bottom, top, high, row)));
                        break;
                    case 3:
                        right = my.dice.right;
                        left = my.dice.left;
                        row = my.dice.top;
                        high = my.dice.bottom;
                        bottom = my.dice.row;
                        top = my.dice.high;
                        row = copy(nx, ny, row);
                        stringBuilder.append(high + "\n");
                        queue.add(new My(nx, ny, new Dice(right, left, bottom, top, high, row)));
                        break;
                    case 4:
                        right = my.dice.right;
                        left = my.dice.left;
                        row = my.dice.bottom;
                        high = my.dice.top;
                        bottom = my.dice.high;
                        top = my.dice.row;
                        row = copy(nx, ny, row);
                        stringBuilder.append(high + "\n");
                        queue.add(new My(nx, ny, new Dice(right, left, bottom, top, high, row)));
                        break;
                }
            } else {
                queue.add(my);
            }
        }
    }

    public static int copy(int nx, int ny, int row) {
        if (ints[nx][ny] == 0) {
            ints[nx][ny] = row;
            return row;
        } else {
            int num = ints[nx][ny];
            ints[nx][ny] = 0;
            return num;
        }
    }
}

class Dice {
    int right;
    int left;
    int bottom;
    int top;
    int high;
    int row;

    public Dice(int right, int left, int bottom, int top, int high, int row) {
        this.right = right;
        this.left = left;
        this.bottom = bottom;
        this.top = top;
        this.high = high;
        this.row = row;
    }
}

class My {
    int x;
    int y;
    Dice dice;

    public My(int x, int y, Dice dice) {
        this.x = x;
        this.y = y;
        this.dice = dice;
    }
}
