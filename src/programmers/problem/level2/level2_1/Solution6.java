package programmers.problem.level2.level2_1;

public class Solution6 {
    public int solution(int n) {
        if (n < 3) {
            return 1;
        }
        int rt = 2, lt = 1, result = 1;
        int sum = lt + rt;
        while (rt < n) {
            if (sum < n) {
                sum += ++rt;
                continue;
            }
            if (sum == n) result++;
            sum -= lt++;
        }
        return result;
    }
}
