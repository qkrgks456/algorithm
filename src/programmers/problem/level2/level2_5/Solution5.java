package programmers.problem.level2.level2_5;

public class Solution5 {
    int solution(int[][] land) {
        int result = 0;
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int max = 0;
                for (int k = 0; k < land[0].length; k++) {
                    if (j == k) continue;
                    max = Math.max(land[i][j] + land[i - 1][k], max);
                }
                land[i][j] = Math.max(land[i][j], max);
                result = Math.max(land[i][j], result);
            }
        }
        return result;
    }
}
