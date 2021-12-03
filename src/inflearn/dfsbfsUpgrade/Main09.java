package inflearn.dfsbfsUpgrade;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main09 {
    static int[][] ints;
    static int result = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ints = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            String str = bufferedReader.readLine();
            String[] strings = str.split(" ");
            for (int j = 0; j < 7; j++) {
                ints[i][j + 1] = Integer.parseInt(strings[j]);
            }
        }
        ints[1][1] = 1;
        DFS(1, 1);
        System.out.println(result);
    }

    public static void DFS(int x, int y) {
        if (x == 7 && y == 7) {
            result++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && ints[nx][ny] == 0) {
                    ints[nx][ny] = 1;
                    DFS(nx, ny);
                    ints[nx][ny] = 0;
                }
            }
        }
    }
}
