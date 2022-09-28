package programmers.problem.level1_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            int n = commands[i][0] - 1;
            int n1 = commands[i][1] - 1;
            int n2 = commands[i][2] - 1;
            List<Integer> list = new ArrayList<>();
            for (int j = n; j <= n1; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            result.add(list.get(n2));
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
