package baekjoon.v1.etc8;


import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main21610 {
    static int N, M;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] ch, ints;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[N][N];
        List<Point> cloud = new ArrayList<>();
        cloud.add(new Point(N - 2, 0));
        cloud.add(new Point(N - 2, 1));
        cloud.add(new Point(N - 1, 0));
        cloud.add(new Point(N - 1, 1));
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int direction = Integer.parseInt(stringTokenizer.nextToken());
            int count = Integer.parseInt(stringTokenizer.nextToken());
            ch = new int[N][N];
            move(direction, count, cloud);
            cloud.clear();
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (ch[j][k] == 0 && ints[j][k] >= 2) {
                        cloud.add(new Point(j, k));
                        ints[j][k] -= 2;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += ints[i][j];
            }
        }
        System.out.println(result);
    }

    public static void move(int direction, int count, List<Point> cloud) {
        int nx, ny;
        for (Point point : cloud) {
            // 아 여기서 점들 이동시킬때 공식이 말도 안되는데 ?? 일단 헤아려보자
            nx = (point.x + N + dx[direction] * count % N) % N;
            ny = (point.y + N + dy[direction] * count % N) % N;
            ints[nx][ny]++;
            ch[nx][ny] = 1;
            point.x = nx;
            point.y = ny;
        }
        cloudCheck(cloud);
    }

    public static void cloudCheck(List<Point> cloud) {
        for (Point point : cloud) {
            int nx, ny;
            int count = 0;
            for (int i = 2; i <= 8; i += 2) {
                nx = dx[i] + point.x;
                ny = dy[i] + point.y;
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && ints[nx][ny] > 0) {
                    count++;
                }
            }
            ints[point.x][point.y] += count;
        }

    }
}
