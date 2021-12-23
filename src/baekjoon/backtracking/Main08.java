package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main08 {
    // 진짜 나쁜놈이네 이렇게 교과서적으로 푸는게 가능하다고 ?? 진짜 말도 안된다 이말이에요 ~
    // 이걸 어케 푸냐고
    static int n;
    static int min = Integer.MAX_VALUE;
    static int[] ch;
    static int[][] ints;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        ints = new int[n][n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            String[] strings = s.split(" ");
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(strings[j]);
            }
        }
        DFS(0, 0);
        System.out.println(min);
    }

    public static void DFS(int idx, int depth) {
        if (depth == n / 2) {
            // 구별 다 끝났으면 start,link 능력치 구하는 메서드
            team();
            return;
        } else {
            // 팀 구성할 때 포함된 애들 포함 안된 애들로 구별
            for (int i = idx; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i + 1, depth + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void team() {
        int start = 0;
        int link = 0;
        // 유의 해야 할점은
        // j = i + 1 이 아니라면 중복된 애들이 나옴 i == j 랑 같으면 안되자누
        // 그리고 i + 1 이라서 n - 1 해줘야 한다
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ch[i] == 1 && ch[j] == 1) {
                    start += ints[i][j];
                    start += ints[j][i];
                } else if (ch[i] == 0 && ch[j] == 0) {
                    link += ints[i][j];
                    link += ints[j][i];
                }
            }
        }
        // 음수면 안되자누
        int num = Math.abs(start - link);
        // 최소값이 0이면 더 할 필요 없자누
        if (num == 0) {
            System.out.println(0);
            System.exit(0);
        }
        min = Math.min(num, min);
    }
}
