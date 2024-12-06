package baekjoon.v1.etc4;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main2638 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static List<Point> list;
    static int[][] ints;
    static int cheeseCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (ints[i][j] == 1) {
                    list.add(new Point(i, j));
                    cheeseCount++;
                }
            }
        }
        int result = 0;
        while (true) {
            result++;
            // 공기랑 접촉되는 애들 리스트로 넣음
            BFS();
            // 그 애들 상하좌우 확인 할꺼 2면 넘치면 공기됨
            directionCheck();
            // 다 녹았는지 확인
            if (cheeseCount == 0) {
                System.out.println(result);
                break;
            }
        }
    }

    public static void directionCheck() {
        int nx, ny;
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            int x = list.get(i).x;
            int y = list.get(i).y;
            for (int j = 0; j < 4; j++) {
                nx = x + dx[j];
                ny = y + dy[j];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && ints[nx][ny] == 2) {
                    count++;
                }
            }
            // 2면이 접촉해 있으면
            if (count >= 2) {
                list.remove(i);
                ints[x][y] = 0;
                cheeseCount--;
                i--;
            }
        }
    }

    public static void BFS() {
        int[][] check = new int[N][M];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        check[0][0] = 1;
        ints[0][0] = 2;
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (check[nx][ny] == 0 && ints[nx][ny] != 1) {
                        check[nx][ny] = 1;
                        if (ints[nx][ny] == 0) {
                            ints[nx][ny] = 2;
                        }
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
