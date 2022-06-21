package baekjoon.etc8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main15683 {
    static int answer = Integer.MAX_VALUE;
    static int count = 0;
    static int n, m;
    static int[] result;
    static List<CCTV> list = new ArrayList<>();
    static int[][] ints;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (ints[i][j] > 0 && ints[i][j] <= 5) {
                    list.add(new CCTV(i, j, ints[i][j]));
                    count++;
                }
            }
        }
        result = new int[count];
        DFS(0);
        System.out.println(answer);
    }

    public static void DFS(int level) {
        if (level == count) {
            /* 일단 이차원 배열 만들기 */
            int[][] check = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    check[i][j] = ints[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                cctvCheck(list.get(i), result[i], check);
            }
            int count2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (check[i][j] == 0) count2++;
                }
            }
            answer = Math.min(answer, count2);
            return;
        }

        for (int i = 0; i < 4; i++) {
            result[level] = i;
            DFS(level + 1);
        }
    }

    // 방향 0 오른쪽 1 왼쪽 2 아래쪽 3 위쪽
    public static void cctvCheck(CCTV cctv, int direction, int[][] check) {
        switch (cctv.type) {
            case 1:
                watch(cctv.x, cctv.y, direction, check);
                break;
            case 2:
                switch (direction) {
                    case 0:
                    case 1:
                        watch(cctv.x, cctv.y, 0, check);
                        watch(cctv.x, cctv.y, 1, check);
                        break;
                    case 2:
                    case 3:
                        watch(cctv.x, cctv.y, 2, check);
                        watch(cctv.x, cctv.y, 3, check);
                        break;
                }
                break;
            case 3:
                switch (direction) {
                    case 0:
                        watch(cctv.x, cctv.y, 3, check);
                        watch(cctv.x, cctv.y, 0, check);
                        break;
                    case 1:
                        watch(cctv.x, cctv.y, 2, check);
                        watch(cctv.x, cctv.y, 0, check);
                        break;
                    case 2:
                        watch(cctv.x, cctv.y, 2, check);
                        watch(cctv.x, cctv.y, 1, check);
                        break;
                    case 3:
                        watch(cctv.x, cctv.y, 3, check);
                        watch(cctv.x, cctv.y, 1, check);
                        break;
                }
                break;
            case 4:
                switch (direction) {
                    case 0:
                        watch(cctv.x, cctv.y, 0, check);
                        watch(cctv.x, cctv.y, 1, check);
                        watch(cctv.x, cctv.y, 3, check);
                        break;
                    case 1:
                        watch(cctv.x, cctv.y, 0, check);
                        watch(cctv.x, cctv.y, 2, check);
                        watch(cctv.x, cctv.y, 3, check);
                        break;
                    case 2:
                        watch(cctv.x, cctv.y, 0, check);
                        watch(cctv.x, cctv.y, 1, check);
                        watch(cctv.x, cctv.y, 2, check);
                        break;
                    case 3:
                        watch(cctv.x, cctv.y, 1, check);
                        watch(cctv.x, cctv.y, 2, check);
                        watch(cctv.x, cctv.y, 3, check);
                        break;
                }
                break;
            case 5:
                watch(cctv.x, cctv.y, 0, check);
                watch(cctv.x, cctv.y, 1, check);
                watch(cctv.x, cctv.y, 2, check);
                watch(cctv.x, cctv.y, 3, check);
                break;
        }
    }

    // 방향 0 오른쪽 1 왼쪽 2 아래쪽 3 위쪽
    public static void watch(int x, int y, int direction, int[][] check) {
        switch (direction) {
            case 0:
                for (int i = y; i < check[0].length; i++) {
                    if (check[x][i] == 6) break;
                    check[x][i] = -1;
                }
                break;
            case 1:
                for (int i = y; i >= 0; i--) {
                    if (check[x][i] == 6) break;
                    check[x][i] = -1;
                }
                break;
            case 2:
                for (int i = x; i < check.length; i++) {
                    if (check[i][y] == 6) break;
                    check[i][y] = -1;
                }
                break;
            case 3:
                for (int i = x; i >= 0; i--) {
                    if (check[i][y] == 6) break;
                    check[i][y] = -1;
                }
                break;
        }
    }

}

class CCTV {
    int x;
    int y;
    int type;

    public CCTV(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
