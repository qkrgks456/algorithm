package programmers.problem.level1.level1_4;

import java.util.Arrays;

public class Solution6 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int result = 0;
        for (int i = 0; i < d.length; i++) {
            budget -= d[i];
            if (budget < 0) break;
            result++;
        }
        return result;
    }
}
