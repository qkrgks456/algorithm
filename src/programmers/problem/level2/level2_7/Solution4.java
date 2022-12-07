package programmers.problem.level2.level2_7;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public int[] solution(int n) {
        int[][] ints = new int[n][n];
        int x = -1;
        int y = 0;
        int num = 0;
        int move = n;
        while (move > 0) {
            for (int i = 0; i < move; i++) {
                ints[++x][y] = ++num;
            }
            for (int i = 0; i < move - 1; i++) {
                ints[x][++y] = ++num;
            }
            for (int i = 0; i < move - 2; i++) {
                ints[--x][--y] = ++num;
            }
            move -= 3;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                if (ints[i][j] != 0) {
                    list.add(ints[i][j]);
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

}
