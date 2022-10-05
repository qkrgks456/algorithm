package programmers.problem.level1.level1_1;

public class Solution7 {
    public int solution(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            int co = numCount(i);
            if (co % 2 == 0) {
                result += i;
            } else {
                result -= i;
            }
        }
        return result;
    }

    public int numCount(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) count++;
            else if (n % i == 0) count += 2;
        }
        return count;
    }

}
