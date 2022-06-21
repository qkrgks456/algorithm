package baekjoon.etc8;


import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main21610 {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        int[][] ints = new int[N][N];
        List<Point> cloud = new ArrayList<>();
        cloud.add(new Point(N - 2, 0));
        cloud.add(new Point(N - 2, 1));
        cloud.add(new Point(N - 1, 0));
        cloud.add(new Point(N - 1, 1));
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int direction = Integer.parseInt(stringTokenizer.nextToken());
            int count = Integer.parseInt(stringTokenizer.nextToken());
            move(direction, count, cloud);
            break;
        }
    }

    public static void move(int direction, int count, List<Point> cloud) {
        int num = 0;
        int num2 = 0;
        switch (direction) {
            case 1:
                for (Point point : cloud) {
                    num = point.y - count;
                    if (Math.abs(num) >= N) {
                        point.y = N - (Math.abs(num) % N) == N ? 0 : N - (Math.abs(num) % N);
                    } else {
                        point.y = N - Math.abs(num);
                    }
                }
                break;
            case 2:
                for (Point point : cloud) {
                    num = point.y - count;
                    num2 = point.x - count;

                }
                break;
            case 3:
                for (Point point : cloud) {
                    num = point.x - count;
                    if (Math.abs(num) >= N) {
                        point.x = N - (Math.abs(num) % N) == N ? 0 : N - (Math.abs(num) % N);
                    } else {
                        point.x = N - Math.abs(num);
                    }
                }
                break;
            case 4:
                break;
            case 5:
                for (Point point : cloud) {
                    num = point.y + count;
                    if (num >= N) {
                        point.y = num % N;
                    } else {
                        point.y = num;
                    }
                }
                break;
            case 6:
                break;
            case 7:
                for (Point point : cloud) {
                    num = point.x + count;
                    if (num >= N) {
                        point.x = num % N;
                    } else {
                        point.x = num;
                    }
                }
                break;
            case 8:
                break;
        }
    }
}
