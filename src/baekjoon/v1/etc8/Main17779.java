package baekjoon.v1.etc8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17779 {
    static int n;
    static int[][] ints, ch;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        ints = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= n; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        // 경우의 수 부터 뽑아야 한다 조건에 맞도록
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                for (int d1 = 1; d1 <= n; d1++) {
                    for (int d2 = 1; d2 <= n; d2++) {
                        if (y - d1 >= 1 && x + d1 + d2 <= n && y + d2 <= n) {
                            line(x, y, d1, d2);
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void line(int x, int y, int d1, int d2) {
        int[] popul = new int[6];
        // 일단 5번 인구수 구하기
        ch = new int[n + 1][n + 1];
        int left = 0;
        int right = 0;
        boolean lCheck = true;
        boolean rCheck = true;
        for (int i = x; i <= x + d1 + d2; i++) {
            for (int j = y + left; j <= y + right; j++) {
                popul[5] += ints[i][j];
                ch[i][j] = 5;
            }
            // 언제 한줄이 왼쪽가냐 오른쪽 가냐를 추측해 봐야겠네
            if (left == -d1) {
                lCheck = false;
            }
            if (right == d2) {
                rCheck = false;
            }
            if (lCheck) {
                left--;
            } else {
                left++;
            }
            if (rCheck) {
                right++;
            } else {
                right--;
            }
        }
        // 1번
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if (ch[i][j] != 5) {
                    popul[1] += ints[i][j];
                }
            }
        }
        // 2번
        for (int i = 1; i <= x + d2; i++) {
            for (int j = y + 1; j <= n; j++) {
                if (ch[i][j] != 5) {
                    popul[2] += ints[i][j];
                }
            }
        }
        // 3번
        for (int i = x + d1; i <= n; i++) {
            for (int j = 1; j < y - d1 + d2; j++) {
                if (ch[i][j] != 5) {
                    popul[3] += ints[i][j];
                }
            }
        }
        // 4번
        for (int i = x + d2 + 1; i <= n; i++) {
            for (int j = y - d1 + d2; j <= n; j++) {
                if (ch[i][j] != 5) {
                    popul[4] += ints[i][j];
                }
            }
        }

        // 인구수를 통한 차이 구하기
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < popul.length; i++) {
            max = Math.max(max, popul[i]);
            min = Math.min(min, popul[i]);
        }
        result = Math.min(result, max - min);
    }
}
