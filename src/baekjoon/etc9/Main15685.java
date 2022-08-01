package baekjoon.etc9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main15685 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] ints = new int[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());
            int g = Integer.parseInt(stringTokenizer.nextToken());
            curve(x, y, d, g);
        }
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (ints[i][j] == 1 && ints[i + 1][j] == 1 && ints[i + 1][j + 1] == 1 && ints[i][j + 1] == 1) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static void curve(int x, int y, int d, int g) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        ints[nx][ny] = 1;
        ints[x][y] = 1;
        stack.add(d);
        list.add(d);
         // 커브 세대로 돌리자
        for (int i = 0; i < g; i++) {
            int size = stack.size();
            int nx2, ny2;
            for (int j = 0; j < size; j++) {
                Integer integer = stack.pop();
                int check = integer + 1 == 4 ? 0 : integer + 1;
                nx2 = nx + dx[check];
                ny2 = ny + dy[check];
                ints[nx2][ny2] = 1;
                nx = nx2;
                ny = ny2;
                list.add(check);
            }
            for (Integer integer : list) {
                stack.add(integer);
            }
        }
    }
}
