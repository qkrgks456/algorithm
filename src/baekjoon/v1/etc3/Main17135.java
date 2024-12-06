package baekjoon.v1.etc3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17135 {
    static int[][] ints, check, die, map;
    static int N, M, D, result;
    static int[] location;
    static int[] ch;
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        D = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        location = new int[3];
        ch = new int[M];
        // 일단 경우의 수 뽑기 3명 놓는거
        DFS(0, 0);
        System.out.println(result);
    }

    public static void DFS(int level, int idx) {
        if (level == 3) {
            defense();
            return;
        }
        for (int i = idx; i < M; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                location[level] = i;
                DFS(level + 1, i);
                ch[i] = 0;
            }
        }
    }

    // 아 다시
    public static void defense() {
        int count = 0;
        // 일단 복사따자 계속 변경될꺼니까
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = ints[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            die = new int[N][M];
            for (int n : location) {
                BFS(n);
            }
            // 죽임 당한애들 확인
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (die[j][k] == 1) {
                        map[j][k] = 0;
                        count++;
                    }
                }
            }
            // 움직이자
            move(i);
        }
        result = Math.max(result, count);
    }

    // 이거 탐색범위 씨부릴
    public static void BFS(int n) {
        // 내자리 병사면 죽이고 리턴
        if (map[N - 1][n] == 1) {
            die[N - 1][n] = 1;
            return;
        }
        Queue<Point> queue = new LinkedList<>();
        check = new int[N][M];
        int nx, ny;
        check[N - 1][n] = 1;
        queue.add(new Point(N - 1, n));
        // 아 여기가 이해가 안가는데
        for (int cnt = 1; cnt < D; cnt++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Point point = queue.poll();
                for (int k = 0; k < 3; k++) {
                    nx = point.x + dx[k];
                    ny = point.y + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && check[nx][ny] == 0) {
                        if (map[nx][ny] == 1) {
                            die[nx][ny] = 1;
                            return;
                        }
                        check[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void move(int idx) {
        for (int i = N - 1; i >= idx; i--) {
            if (i == idx) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = 0;
                }
            } else {
                for (int j = 0; j < M; j++) {
                    map[i][j] = map[i - 1][j];
                }
            }
        }
    }
}
