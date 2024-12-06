package baekjoon.v1.etc9;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main20058 {
    static int[][] ints;
    static int n, num;
    static int result = 0;
    static int[][] check, ch;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        int q = Integer.parseInt(stringTokenizer.nextToken());
        num = (int) Math.pow(2, n);
        ints = new int[num][num];
        for (int i = 0; i < num; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < num; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < q; i++) {
            int level = Integer.parseInt(stringTokenizer.nextToken());
            divide(level);
        }
        // 결과 구하기
        int sum = 0;
        ch = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                sum += ints[i][j];
                if (ch[i][j] == 0 && ints[i][j] != 0) {
                    BFS(i, j);
                }
            }
        }
        System.out.println(sum);
        System.out.println(result);

    }

    private static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        ch[x][y] = 1;
        int nx, ny;
        int count = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < num && ny < num && ch[nx][ny] == 0 && ints[nx][ny] != 0) {
                    ch[nx][ny] = 1;
                    count++;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        result = Math.max(result, count);
    }

    // 일단 구역을 정해야 하는데
    public static void divide(int level) {
        check = new int[num][num];
        int len = (int) Math.pow(2, level);
        for (int i = 0; i < num; i += len) {
            for (int j = 0; j < num; j += len) {
                rotate(i, j, len);
            }
        }
        // 회전 완료후 녹이기 복사한녀석 이용 한번에 녹는다는 가정
        int[][] melt = new int[num][num];
        for (int i = 0; i < num; i++) {
            melt[i] = Arrays.copyOf(check[i], num);
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (check[i][j] != 0) {
                    int count = 0;
                    int nx, ny;
                    for (int k = 0; k < 4; k++) {
                        nx = dx[k] + i;
                        ny = dy[k] + j;
                        if (nx >= 0 && ny >= 0 && nx < num && ny < num && check[nx][ny] != 0) {
                            count++;
                        }
                    }
                    if (count < 3) {
                        melt[i][j]--;
                    }
                }
            }
        }
        // 원래 배열에 다시 넣어 주기
        for (int i = 0; i < num; i++) {
            ints[i] = Arrays.copyOf(melt[i], num);
        }
    }

    static void rotate(int r, int c, int L) {
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                check[r + j][c + L - i - 1] = ints[r + i][c + j];
            }
        }
    }
}
