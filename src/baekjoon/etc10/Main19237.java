package baekjoon.etc10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main19237 {
    static int dx[] = {0, -1, 1, 0, 0};
    static int dy[] = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        List<Shark> list = new ArrayList<>();
        int[][] ints = new int[N][N];
        Small[][] smalls = new Small[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                if (num != 0) {
                    list.add(new Shark(i, j, 0, num));
                    smalls[i][j] = new Small(num, k);
                    ints[i][j] = num;
                }
            }
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            int direction = Integer.parseInt(stringTokenizer.nextToken());
            Shark shark = list.get(i);
            shark.d = direction;
        }

        for (int i = 0; i < M; i++) {
            Shark shark = list.get(i);
            int[][] priority = new int[5][5];
            for (int j = 1; j <= 4; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int l = 0; l < 4; l++) {
                    priority[j][l] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            shark.priority = priority;
        }
        for (int i = 1; i <= 1000; i++) {
            // 일단 시작하면 냄새 기간 깎기
            for (int j = 0; j < N; j++) {
                for (int l = 0; l < N; l++) {
                    if (smalls[j][l] != null) {
                        smalls[j][l].count--;
                        if (smalls[j][l].count == 0) {
                            smalls[j][l] = null;
                        }
                    }
                }
            }
        }

    }
}

class Shark {
    int x;
    int y;
    int d;
    int num;
    int[][] priority;

    public Shark(int x, int y, int d, int num) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.num = num;
    }

    public int[] getDirection() {
        int[] ints = new int[5];
        for (int i = 1; i < priority.length; i++) {
            ints[i] = priority[this.d][i];
        }
        return ints;
    }
}

class Small {
    int num;
    int count;

    public Small(int num, int count) {
        this.num = num;
        this.count = count;
    }
}
