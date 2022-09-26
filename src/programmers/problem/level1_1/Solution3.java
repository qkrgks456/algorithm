package programmers.problem.level1_1;

public class Solution3 {

    public int solution(int[][] sizes) {
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int check = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = check;
            }
        }
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;
        for (int i = 0; i < sizes.length; i++) {
            xMax = Math.max(xMax, sizes[i][0]);
            yMax = Math.max(yMax, sizes[i][1]);
        }
        return xMax * yMax;
    }
}
