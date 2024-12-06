package baekjoon.v1.etc9;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main17822 {
    static int[][] ints;
    static int N, M, T;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        T = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[N + 1][M];
        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        for (int i = 0; i < T; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            rotate(x, d, k);
            List<Point> list = meetCheck();
            if (list.size() > 0) {
                for (Point point : list) {
                    ints[point.x][point.y] = 0;
                }
            } else {
                int sum = 0;
                int count = 0;
                for (int j = 1; j <= N; j++) {
                    for (int l = 0; l < M; l++) {
                        if (ints[j][l] != 0) {
                            sum += ints[j][l];
                            count++;
                        }
                    }
                }
                double aver = (float) sum / (float) count;
                for (int j = 1; j <= N; j++) {
                    for (int l = 0; l < M; l++) {
                        if (ints[j][l] != 0) {
                            if (ints[j][l] > aver) {
                                ints[j][l]--;
                            } else if (ints[j][l] < aver) {
                                ints[j][l]++;
                            }
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int j = 1; j <= N; j++) {
            for (int l = 0; l < M; l++) {
                result += ints[j][l];
            }
        }
        System.out.println(result);
    }

    // 좌우검사랑 위아래 검사 2개를 진행 해줘야 하네 인접하면서 수가 같은지
    // 있으면 지우는 로직, 아얘 없으면 원판에 수 평균 구하고 평균보다 큰수에서 1빼고 작은수에는 1더하기

    private static void rotate(int x, int d, int k) {
        for (int i = x; i <= N; i += x) {
            if (d == 0) {
                for (int j = 0; j < k; j++) {
                    int ch = ints[i][M - 1];
                    for (int l = M - 1; l > 0; l--) {
                        ints[i][l] = ints[i][l - 1];
                    }
                    ints[i][0] = ch;
                }
            } else {
                for (int j = 0; j < k; j++) {
                    int ch = ints[i][0];
                    for (int l = 0; l < M - 1; l++) {
                        ints[i][l] = ints[i][l + 1];
                    }
                    ints[i][M - 1] = ch;
                }
            }
        }
    }

    private static List<Point> meetCheck() {
        List<Point> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                int num = ints[i][j];
                if (num != 0) {
                    int left = j - 1 < 0 ? M - 1 : j - 1;
                    int right = j + 1 == M ? 0 : j + 1;
                    int top = i + 1 <= N ? i + 1 : -1;
                    int bottom = i - 1 > 0 ? i - 1 : -1;
                    if (num == ints[i][left]) list.add(new Point(i, left));
                    if (num == ints[i][right]) list.add(new Point(i, right));
                    if (top != -1) {
                        if (num == ints[top][j]) list.add(new Point(top, j));
                    }
                    if (bottom != -1) {
                        if (num == ints[bottom][j]) list.add(new Point(bottom, j));
                    }
                }
            }
        }
        return list;
    }
}
