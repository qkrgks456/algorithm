package inflearn.dfsbfsUpgrade;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main12 {
    static int[] dx = {1, -1, 0, 0, -1, 1};
    static int[] dy = {0, 0, 1, -1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(strings[j]);
            }
        }
    }

}
