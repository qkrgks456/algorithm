package baekjoon.v1.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main17144 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int r, c, t;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());
        t = Integer.parseInt(stringTokenizer.nextToken());
        int[][] ints = new int[r][c];
        List<Integer> location = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < c; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (ints[i][j] == -1) {
                    location.add(i);
                }
            }
        }
        int[][] diffusionAfter = diffusion(ints);
        int[][] runAfter = run(location, diffusionAfter);
        for (int i = 1; i < t; i++) {
            diffusionAfter = diffusion(runAfter);
            runAfter = run(location, diffusionAfter);
        }
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (runAfter[i][j] <= 0) continue;
                sum += runAfter[i][j];
            }
        }
        System.out.println(sum);
    }

    public static int[][] run(List<Integer> location, int[][] after) {
        int top = location.get(0);
        int bottom = location.get(1);

        // 위쪽 공기 청정기
        for (int i = top - 1; i > 0; i--) {
            after[i][0] = after[i - 1][0];
        }

        for (int i = 0; i < c - 1; i++) {
            after[0][i] = after[0][i + 1];
        }

        for (int i = 0; i < top; i++) {
            after[i][c - 1] = after[i + 1][c - 1];
        }

        for (int i = c - 1; i > 1; i--) {
            after[top][i] = after[top][i - 1];
        }
        after[top][1] = 0;
        // 아래쪽 공기 청정기
        for (int i = bottom + 1; i < r - 1; i++) {
            after[i][0] = after[i + 1][0];
        }

        for (int i = 0; i < c - 1; i++) {
            after[r - 1][i] = after[r - 1][i + 1];
        }

        for (int i = r - 2; i >= bottom; i--) {
            after[i + 1][c - 1] = after[i][c - 1];
        }

        for (int i = c - 1; i > 1; i--) {
            after[bottom][i] = after[bottom][i - 1];
        }
        after[bottom][1] = 0;
        return after;
    }


    public static int[][] diffusion(int[][] before) {
        int[][] after = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                after[i][j] = before[i][j];
            }
        }
        int nx, ny;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (before[i][j] <= 0) continue;
                for (int k = 0; k < 4; k++) {
                    nx = i + dx[k];
                    ny = j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < r && ny < c && before[nx][ny] >= 0) {
                        after[nx][ny] += before[i][j] / 5;
                        after[i][j] -= before[i][j] / 5;
                    }
                }
            }
        }
        return after;
    }
}
