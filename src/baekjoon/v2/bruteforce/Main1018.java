package baekjoon.v2.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main1018 {
    public static void main(String[] args) throws Exception {
        String[][] checkW = {
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
        };
        String[][] checkB = {
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"}
        };
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        String[][] strings = new String[n][m];

        for (int i = 0; i < strings.length; i++) {
            String[] strs = bufferedReader.readLine().split("");
            for (int j = 0; j < strings[i].length; j++) {
                strings[i][j] = strs[j];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                if (i + 8 > strings.length || j + 8 > strings[i].length) continue;
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (!Objects.equals(strings[i + k][j + l], checkB[k][l])) count++;
                    }
                }
                result = Math.min(count, result);
                count = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (!Objects.equals(strings[i + k][j + l], checkW[k][l])) count++;
                    }
                }
                result = Math.min(count, result);
            }
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(result);
    }
}

