package baekjoon.v1.etc9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main17143 {
    static int result = 0;
    static Shark[][] sharks;
    static int x, y, m;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
    static List<Shark> list;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        x = Integer.parseInt(stringTokenizer.nextToken());
        y = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        sharks = new Shark[x + 1][y + 1];
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());
            int z = Integer.parseInt(stringTokenizer.nextToken());
            sharks[x][y] = new Shark(x, y, s, d, z);
        }

        // 낚시왕 이동
        for (int i = 1; i <= y; i++) {
            // 낚시하기
            for (int j = 1; j <= x; j++) {
                if (sharks[j][i] != null) {
                    result += sharks[j][i].z;
                    sharks[j][i] = null;
                    break;
                }
            }
            // 리스트로 옮겨서 무빙
            list = new ArrayList<>();
            for (int j = 0; j < sharks.length; j++) {
                for (int k = 0; k < sharks[j].length; k++) {
                    if (sharks[j][k] != null) {
                        list.add(sharks[j][k]);
                    }
                }
            }
            move();
        }
        System.out.println(result);
    }

    public static void move() {
        sharks = new Shark[x + 1][y + 1];
        for (Shark shark : list) {
            if (shark.d == 3 || shark.d == 4) {
                int count = shark.s % ((y - 1) * 2);
                while (count > 0) {
                    count--;
                    int ny = shark.y + dy[shark.d];
                    if (ny < 1 || ny > y) {
                        shark.d = shark.d - 1 == 3 ? 3 : 4;
                        shark.y += dy[shark.d];
                    } else {
                        shark.y = ny;
                    }
                }
            } else {
                int count = shark.s % ((x - 1) * 2);
                while (count > 0) {
                    count--;
                    int nx = shark.x + dx[shark.d];
                    if (nx < 1 || nx > x) {
                        shark.d = shark.d - 1 == 1 ? 1 : 2;
                        shark.x += dx[shark.d];
                    } else {
                        shark.x = nx;
                    }
                }
            }
            // 상어가 이미 있는지 없는지 없으면 바로 넣어주고 있으면 크기 비교해서 클때만 넣어주고
            if (sharks[shark.x][shark.y] == null) {
                sharks[shark.x][shark.y] = new Shark(shark.x, shark.y, shark.s, shark.d, shark.z);
            } else {
                if (sharks[shark.x][shark.y].z < shark.z) {
                    sharks[shark.x][shark.y] = new Shark(shark.x, shark.y, shark.s, shark.d, shark.z);
                }
            }
        }
    }
}

class Shark {
    int x;
    int y;
    int s;
    int d;
    int z;

    public Shark(int x, int y, int s, int d, int z) {
        this.x = x;
        this.y = y;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}
