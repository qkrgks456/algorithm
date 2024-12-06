package baekjoon.v1.etc8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main20056 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static List<FireBoll> list = new ArrayList<>();
    static List<FireBoll>[][] map;
    static int[][] ch;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        // 리스트 자리별로 보관용도
        map = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        // 입력
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            int mass = Integer.parseInt(stringTokenizer.nextToken());
            int speed = Integer.parseInt(stringTokenizer.nextToken());
            int direction = Integer.parseInt(stringTokenizer.nextToken());
            list.add(new FireBoll(r, c, mass, speed, direction));
        }
        // 명령 시작
        for (int i = 0; i < k; i++) {
            // 1. 모든 파이어볼이 이동
            int nx, ny;
            ch = new int[n][n];
            for (FireBoll fireBoll : list) {
                nx = (fireBoll.r + n + dx[fireBoll.direction] * fireBoll.speed % n) % n;
                ny = (fireBoll.c + n + dy[fireBoll.direction] * fireBoll.speed % n) % n;
                fireBoll.r = nx;
                fireBoll.c = ny;
                map[nx][ny].add(fireBoll);
            }
            // 2. 이동 후 리스트 확인
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (map[j][l].size() <= 1) {
                        map[j][l].clear();
                        continue;
                    }
                    // 2개 이상 파이어볼 로직
                    int massSum = 0;
                    int speedSum = 0;
                    int size = map[j][l].size();
                    boolean even = map[j][l].get(0).direction % 2 == 0;
                    boolean odd = map[j][l].get(0).direction % 2 != 0;
                    for (FireBoll fireBoll : map[j][l]) {
                        massSum += fireBoll.mass;
                        speedSum += fireBoll.speed;
                        even = even && fireBoll.direction % 2 == 0;
                        odd = odd && fireBoll.direction % 2 != 0;
                        list.remove(fireBoll);
                    }
                    map[j][l].clear();
                    if (massSum / 5 == 0) {
                        continue;
                    }
                    // 홀수 짝수 방향 정하기
                    for (int o = 0; o < 4; o++) {
                        if (even || odd) {
                            list.add(new FireBoll(j, l, massSum / 5, speedSum / size, o * 2));
                        } else {
                            list.add(new FireBoll(j, l, massSum / 5, speedSum / size, o * 2 + 1));
                        }
                    }
                }
            }
        }
        int result = 0;
        for (FireBoll fireBoll : list) {
            result += fireBoll.mass;
        }
        System.out.println(result);
    }
}

class FireBoll {
    int r;
    int c;
    int mass;
    int speed;
    int direction;

    public FireBoll(int r, int c, int mass, int speed, int direction) {
        this.r = r;
        this.c = c;
        this.mass = mass;
        this.speed = speed;
        this.direction = direction;
    }
}