package programmers.problem.level1.level1_2;

public class Solution1 {
    public int solution(int[] absolutes, boolean[] signs) {
        int result = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                result += absolutes[i];
            } else {
                result -= absolutes[i];
            }
        }
        return result;
    }
}
