package programmers.problem.level2.level2_8;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] ints = new int[rows][columns];
        int n = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++, n++) {
                ints[i][j] = n;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            int ch = ints[x1][y2];
            int result = ch;
            for (int i = y2; i > y1; i--) {
                ints[x1][i] = ints[x1][i - 1];
                result = Math.min(result, ints[x1][i]);
            }
            for (int i = x1; i < x2; i++) {
                ints[i][y1] = ints[i + 1][y1];
                result = Math.min(result, ints[i][y1]);
            }
            for (int i = y1; i < y2; i++) {
                ints[x2][i] = ints[x2][i + 1];
                result = Math.min(result, ints[x2][i]);
            }
            for (int i = x2; i > x1; i--) {
                ints[i][y2] = ints[i - 1][y2];
                result = Math.min(result, ints[i][y2]);
            }
            ints[x1 + 1][y2] = ch;
            list.add(result);
        }
        return list.stream()
                .mapToInt(o -> o)
                .toArray();
    }
}
