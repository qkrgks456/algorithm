package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main03 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[][] ints = new int[size][size];
        for (int i = 0; i < size; i++) {
            String s = bufferedReader.readLine();
            String[] strings = s.split("");
            for (int j = 0; j < size; j++) {
                ints[i][j] = Integer.parseInt(strings[j]);
            }
        }

    }
}
